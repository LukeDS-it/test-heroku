package it.test.heroku

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}

import scala.util.Properties

object TestHeroku extends App {
  println("Hello world")

  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] =
      Future.value(
        http.Response(req.version, http.Status.Ok)
      )
  }

  val server = Http.serve(Properties.envOrElse("port", ":8080"), service)
  Await.ready(server)
}
