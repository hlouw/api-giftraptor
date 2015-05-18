package hlouw.giftraptor.api

import akka.actor.{Actor, ActorContext, ActorLogging}
import hlouw.giftraptor.api.resources.{ApiLogging, Users}

class ServiceActor extends Actor with ApiLogging with Users with ActorLogging {

  def actorRefFactory: ActorContext = context

  val routes = logRequestContext(usersRoute)

  def receive: Receive = runRoute(routes)
}
