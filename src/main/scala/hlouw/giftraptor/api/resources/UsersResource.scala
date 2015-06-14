package hlouw.giftraptor.api.resources

import kamon.spray.KamonTraceDirectives._
import spray.routing.HttpService

trait UsersResource extends HttpService {

  val usersRoute = pathPrefix("users") {
    pathEnd {
      get(getUsers)
    } ~
    path(IntNumber) { userId =>
      get(getUser(userId))
    }
  }

  private def getUsers = traceName("/users") {
    complete("Here you go")
  }

  private def getUser(id: Int) = traceName("/users/{id}") {
    complete(s"Got user $id")
  }
}
