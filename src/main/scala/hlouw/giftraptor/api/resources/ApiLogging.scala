package hlouw.giftraptor.api.resources

import akka.actor.ActorRefFactory
import spray.http.HttpRequest
import spray.routing.directives.LoggingMagnet
import spray.util.LoggingContext

trait ApiLogging {

  import spray.routing.directives.DebuggingDirectives._

  implicit def actorRefFactory: ActorRefFactory

  def logger = LoggingContext.fromActorRefFactory

  def printRequestMethod(req: HttpRequest): Unit = logger.info(s"${req.method} ${req.uri}")

  def logRequestContext = logRequest(LoggingMagnet(printRequestMethod))
}