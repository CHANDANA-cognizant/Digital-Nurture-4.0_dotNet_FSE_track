using Confluent.Kafka;
using SharedKafka;
using System.Text.Json;

Console.WriteLine("Enter your username:");
var username = Console.ReadLine();

var config = new ConsumerConfig
{
    BootstrapServers = KafkaConfig.BootstrapServers,
    GroupId = "chat-group",
    AutoOffsetReset = AutoOffsetReset.Earliest
};

// Background task to receive messages
Task.Run(() =>
{
    using var consumer = new ConsumerBuilder<Ignore, string>(config).Build();
    consumer.Subscribe(KafkaConfig.TopicName);

    while (true)
    {
        var message = consumer.Consume();
        var chatMessage = JsonSerializer.Deserialize<ChatMessage>(message.Message.Value);

        if (chatMessage.Sender != username)
            Console.WriteLine($"{chatMessage.Sender}: {chatMessage.Message}");
    }
});

// Producer to send messages
var producerConfig = new ProducerConfig { BootstrapServers = KafkaConfig.BootstrapServers };
using var producer = new ProducerBuilder<Null, string>(producerConfig).Build();

while (true)
{
    var text = Console.ReadLine();
    if (text == "exit") break;

    var message = new ChatMessage { Sender = username, Message = text };
    await producer.ProduceAsync(KafkaConfig.TopicName, new Message<Null, string> { Value = JsonSerializer.Serialize(message) });
}