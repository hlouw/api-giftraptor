package hlouw.giftraptor.api.resources

import spray.routing.HttpService

trait Users extends HttpService {

  val usersRoute = path("users") {
    get {
      complete("Here you go")
    }
  }
}
