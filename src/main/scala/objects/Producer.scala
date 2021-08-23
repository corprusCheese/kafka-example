package objects

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import java.util.Properties

object Producer{
  private val props: Properties = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  private val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](props)
  private val topic: String = "examples"

  def exec(): Unit = {
    for (i <- 1 to 10)
      producer.send(new ProducerRecord(topic, "key", s"hello $i"))

    producer.close()
  }
}
