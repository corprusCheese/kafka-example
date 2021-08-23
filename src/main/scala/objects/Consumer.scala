package objects

import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}

import scala.collection.JavaConverters._
import java.time.Duration
import java.util
import java.util.Properties

object Consumer {
  private val topic: String = "examples"
  private val props: Properties = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "something")
  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)

  def exec(): Unit = {
    consumer.subscribe(util.Collections.singletonList(topic))
    val duration: Duration = Duration.ofMillis(10000)

    val records: ConsumerRecords[String, String] = consumer.poll(duration)
    for (record <- records.asScala)
      println(record.value())

    consumer.close()
  }
}
