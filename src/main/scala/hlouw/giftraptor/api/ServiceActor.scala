package hlouw.giftraptor.api

import akka.actor.Actor
import hlouw.giftraptor.api.resources.{ApiLogging, Users}

class ServiceActor extends Actor with ApiLogging with Users {

  def actorRefFactory = context

  val routes = logRequestContext(usersRoute)

  def receive = runRoute(routes)
}
