package hlouw.giftraptor.api.resources

import akka.event.Logging
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import spray.httpx.RequestBuilding

class ApiLoggingSpec extends Specification with RequestBuilding with ApiLogging with Mockito {

  "Logging" should {

    "create an info level message for a request" in {
      val req = Get("/path")

      val actual = logEntry(req)

      actual.level === Logging.InfoLevel
      actual.obj === "GET /path"
    }
  }

}
