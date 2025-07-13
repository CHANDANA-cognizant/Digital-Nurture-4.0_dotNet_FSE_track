using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SharedKafka
{
    public static class KafkaConfig
    {
        public const string BootstrapServers = "localhost:9092";
        public const string TopicName = "chat-messages";
    }
}
