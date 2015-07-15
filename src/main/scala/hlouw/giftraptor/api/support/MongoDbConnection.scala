package hlouw.giftraptor.api.support

import reactivemongo.api._
import reactivemongo.bson._

object MongoDbConnection extends MongoDbSupport {

  val driver = MongoDriver()
  val connection = driver.connection(List("mongodb"))

  val db = connection("giftraptor")

  val users = db("users")

  val cursor = users.find()
}
