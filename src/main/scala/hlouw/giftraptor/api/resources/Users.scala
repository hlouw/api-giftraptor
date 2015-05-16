package hlouw.giftraptor.api.resources

import kamon.spray.KamonTraceDirectives._
import spray.routing.HttpService

trait Users extends HttpService with ApiLogging {

  val usersRoute = path("users") {
    get {
      traceName("getUsers") {
        logRequestContext(complete("Here you go"))
      }
    }
  }
}
