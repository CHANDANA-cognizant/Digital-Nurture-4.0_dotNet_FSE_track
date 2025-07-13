using Confluent.Kafka;
using Newtonsoft.Json;
using SharedKafka;
using System;
using System.Threading.Tasks;
using System.Windows.Forms;

public partial class Form1 : Form
{
    private IProducer<Null, string> _producer;
    private IConsumer<Ignore, string> _consumer;
    private bool _isRunning = true;
    private System.Windows.Forms.RichTextBox rtbChat;
    private System.Windows.Forms.TextBox txtUsername;
    private System.Windows.Forms.TextBox txtMessage;
    private System.Windows.Forms.Button btnSend;

    public Form1()
    {
        InitializeComponent();
        SetupKafka();
    }

    private void InitializeComponent()
    {
        throw new NotImplementedException();
    }

    private void SetupKafka()
    {
        try
        {
            // Producer configuration
            var producerConfig = new ProducerConfig
            {
                BootstrapServers = KafkaConfig.BootstrapServers,
                MessageTimeoutMs = 5000 // Add timeout for better error handling
            };
            _producer = new ProducerBuilder<Null, string>(producerConfig)
                .SetErrorHandler((_, e) => HandleKafkaError(e))
                .Build();

            // Consumer configuration
            var consumerConfig = new ConsumerConfig
            {
                BootstrapServers = KafkaConfig.BootstrapServers,
                GroupId = "winforms-group-" + Guid.NewGuid().ToString(), // Unique group ID per instance
                AutoOffsetReset = AutoOffsetReset.Earliest,
                EnableAutoCommit = false // Better for chat applications
            };

            _consumer = new ConsumerBuilder<Ignore, string>(consumerConfig)
                .SetErrorHandler((_, e) => HandleKafkaError(e))
                .Build();

            _consumer.Subscribe(KafkaConfig.TopicName);

            // Start consuming messages in background
            Task.Run(ConsumeMessages);
        }
        catch (Exception ex)
        {
            MessageBox.Show($"Failed to initialize Kafka: {ex.Message}");
            Close();
        }
    }

    private void ConsumeMessages()
    {
        while (_isRunning)
        {
            try
            {
                var msg = _consumer.Consume(TimeSpan.FromSeconds(1));
                if (msg != null && !msg.IsPartitionEOF)
                {
                    var chatMsg = JsonConvert.DeserializeObject<ChatMessage>(msg.Message.Value);

                    // Ensure thread-safe UI updates
                    this.Invoke((MethodInvoker)delegate
                    {
                        rtbChat.AppendText($"[{chatMsg.Timestamp:HH:mm:ss}] {chatMsg.Sender}: {chatMsg.Message}{Environment.NewLine}");
                        rtbChat.ScrollToCaret(); // Auto-scroll to new messages
                    });
                }
            }
            catch (ConsumeException ex)
            {
                if (!_isRunning) return; // Expected during shutdown
                this.Invoke((MethodInvoker)delegate
                {
                    rtbChat.AppendText($"[Error] {ex.Error.Reason}{Environment.NewLine}");
                });
            }
            catch (Exception ex)
            {
                if (!_isRunning) return;
                this.Invoke((MethodInvoker)delegate
                {
                    rtbChat.AppendText($"[System Error] {ex.Message}{Environment.NewLine}");
                });
            }
        }
    }

    private void HandleKafkaError(Error error)
    {
        if (!_isRunning) return;
        this.Invoke((MethodInvoker)delegate
        {
            rtbChat.AppendText($"[Kafka Error] {error.Reason}{Environment.NewLine}");
        });
    }

    private async void btnSend_Click(object sender, EventArgs e)
    {
        if (string.IsNullOrWhiteSpace(txtUsername.Text))
        {
            MessageBox.Show("Please enter your username first");
            txtUsername.Focus();
            return;
        }

        if (string.IsNullOrWhiteSpace(txtMessage.Text))
        {
            MessageBox.Show("Please enter a message");
            txtMessage.Focus();
            return;
        }

        try
        {
            var msg = new ChatMessage
            {
                Sender = txtUsername.Text.Trim(),
                Message = txtMessage.Text.Trim()
            };

            var deliveryReport = await _producer.ProduceAsync(
                KafkaConfig.TopicName,
                new Message<Null, string>
                {
                    Value = JsonConvert.SerializeObject(msg)
                });

            txtMessage.Clear();
            txtMessage.Focus();
        }
        catch (ProduceException<Null, string> ex)
        {
            rtbChat.AppendText($"[Send Failed] {ex.Error.Reason}{Environment.NewLine}");
        }
        catch (Exception ex)
        {
            rtbChat.AppendText($"[Send Error] {ex.Message}{Environment.NewLine}");
        }
    }

    protected override void OnFormClosing(FormClosingEventArgs e)
    {
        _isRunning = false;
        try
        {
            _consumer?.Close();
            _consumer?.Dispose();
            _producer?.Flush(TimeSpan.FromSeconds(5));
            _producer?.Dispose();
        }
        catch (Exception ex)
        {
            MessageBox.Show($"Error during shutdown: {ex.Message}");
        }
        base.OnFormClosing(e);
    }
}