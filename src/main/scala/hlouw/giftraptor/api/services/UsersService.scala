package hlouw.giftraptor.api.services

import hlouw.giftraptor.api.entities.User
import hlouw.giftraptor.api.support.MongoDbSupport

class UsersService(mongoDbSupport: MongoDbSupport) {

  def persistUser(user: User) = {
    val usersCol = mongoDbSupport.collection("users")
    usersCol.find
  }
}
