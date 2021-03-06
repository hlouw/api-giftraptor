package hlouw.giftraptor.api.resources

import akka.event.Logging
import spray.http.HttpRequest
import spray.routing.Directive0
import spray.routing.directives.DebuggingDirectives._
import spray.routing.directives.LogEntry

trait ApiLogging {

  def logEntry(req: HttpRequest): LogEntry = LogEntry(s"${req.method} ${req.uri}", Logging.InfoLevel)

  def logRequestContext: Directive0 = logRequest(logEntry _)
}
