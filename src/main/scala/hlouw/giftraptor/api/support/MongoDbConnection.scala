package hlouw.giftraptor.api.support

import reactivemongo.api._
import reactivemongo.api.collections.bson.BSONCollection

import scala.concurrent.ExecutionContext.Implicits.global

object MongoDbConnection extends MongoDbSupport {

  val driver = MongoDriver()
  val connection = driver.connection(List("mongodb"))

  val db = connection.db("giftraptor")

  override def collection(name: String): BSONCollection = db.collection(name)
}
