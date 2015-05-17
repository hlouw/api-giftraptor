package hlouw.giftraptor.api.resources

import kamon.spray.KamonTraceDirectives._
import spray.routing.HttpService

trait Users extends HttpService {

  val usersRoute = path("users") {
    get {
      traceName("getUsers") {
        complete("Here you go")
      }
    }
  }
}
