package hlouw.giftraptor.api

import akka.actor.Actor
import hlouw.giftraptor.api.resources.Users

class ServiceActor extends Actor with Users {

  def actorRefFactory = context

  val routes = usersRoute

  def receive = runRoute(routes)
}
