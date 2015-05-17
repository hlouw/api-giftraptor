package hlouw.giftraptor.api.resources

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class UsersSpec extends Specification with Specs2RouteTest with Users {

  def actorRefFactory = system

  "GET Users" should {

    "return a constant message" in {
      Get("/users") ~> usersRoute ~> check {
        responseAs[String] === "Here you go"
      }
    }
  }

}