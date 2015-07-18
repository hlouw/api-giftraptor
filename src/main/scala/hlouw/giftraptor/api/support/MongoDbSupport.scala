package hlouw.giftraptor.api.support

import reactivemongo.api.collections.bson.BSONCollection


trait MongoDbSupport {

  def collection(name: String): BSONCollection
}
