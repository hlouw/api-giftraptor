package hlouw.giftraptor.api.resources

import akka.actor.ActorSystem
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class UsersSpec extends Specification with Specs2RouteTest with UsersResource {

  def actorRefFactory: ActorSystem = system

  "GET Users" should {

    "return a constant message" in {
      Get("/users") ~> usersRoute ~> check {
        responseAs[String] === "Here you go"
      }
    }

    "return a response for specific user ID" in {
      Get("/users/1234") ~> usersRoute ~> check {
        responseAs[String] === "Got user 1234"
      }
    }

  }

}
