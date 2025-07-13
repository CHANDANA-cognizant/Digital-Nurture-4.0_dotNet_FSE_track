using Confluent.Kafka;
using KafkaShared;
using Newtonsoft.Json;
using SharedKafka;

// Producer Config
var producerConfig = new ProducerConfig { BootstrapServers = KafkaConfig.BootstrapServers };

// Consumer Config
var consumerConfig = new ConsumerConfig
{
    BootstrapServers = KafkaConfig.BootstrapServers,
    GroupId = "cli-group",
    AutoOffsetReset = AutoOffsetReset.Earliest
};

Console.WriteLine("Enter your username:");
var username = Console.ReadLine();

// Start consumer thread
var consumeTask = Task.Run(() =>
{
    using var consumer = new ConsumerBuilder<Ignore, string>(consumerConfig).Build();
    consumer.Subscribe(KafkaConfig.TopicName);

    while (true)
    {
        var msg = consumer.Consume();
        var chatMsg = JsonConvert.DeserializeObject<ChatMessage>(msg.Message.Value);
        if (chatMsg.Sender != username)
            Console.WriteLine($"[{chatMsg.Timestamp}] {chatMsg.Sender}: {chatMsg.Message}");
    }
});

// Producer loop
using var producer = new ProducerBuilder<Null, string>(producerConfig).Build();
while (true)
{
    var input = Console.ReadLine();
    if (input == "exit") break;

    var msg = new ChatMessage { Sender = username, Message = input };
    await producer.ProduceAsync(KafkaConfig.TopicName,
        new Message<Null, string> { Value = JsonConvert.SerializeObject(msg) });
}