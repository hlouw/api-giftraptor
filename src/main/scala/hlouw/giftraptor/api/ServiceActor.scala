package hlouw.giftraptor.api

import akka.actor.{Actor, ActorContext, ActorLogging}
import hlouw.giftraptor.api.resources.{ApiLogging, UsersResource}

class ServiceActor extends Actor with ApiLogging with UsersResource with ActorLogging {

  def actorRefFactory: ActorContext = context

  val routes = logRequestContext(usersRoute)

  def receive: Receive = runRoute(routes)
}
