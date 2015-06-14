package hlouw.giftraptor.api

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import kamon.Kamon
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

object Main extends App {
  
  Kamon.start()

  implicit val system = ActorSystem("giftraptor-spray-can")

  val service = system.actorOf(Props[ServiceActor], "giftraptor-api")

  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "0.0.0.0", port = 8080)
}
