package it.test.heroku


import java.util.UUID

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.util.Properties

object TestHeroku extends App {
  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] =
      Future.value(
        http.Response(req.version, http.Status.Ok)
      )
  }

  val props = new java.util.Properties
  props.put("bootstrap.servers", Properties.envOrElse("CLOUDKARAFKA_BROKERS", ""))
  props.put("client.id", "test")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val kafkaUser = Properties.envOrElse("CLOUDKARAFKA_USERNAME", "")
  val kafkaPass = Properties.envOrElse("CLOUDKARAFKA_PASSWORD", "")
  val jaasCfg =
    s"""org.apache.kafka.common.security.scram.ScramLoginModule required username="$kafkaUser" password="$kafkaPass";"""

  props.put("security.protocol", "SASL_SSL")
  props.put("sasl.mechanism", "SCRAM-SHA-256")
  props.put("sasl.jaas.config", jaasCfg)

  val kafkaProducer = new KafkaProducer[String, String](props)
  kafkaProducer
    .send(new ProducerRecord[String, String]("yby1nkra-default", UUID.randomUUID().toString, "ping"))
    .get()

  val port = Properties.envOrElse("PORT", "8080")
  println(s"binding on $port")
  val server = Http.serve(s":$port", service)
  Await.ready(server)
}
