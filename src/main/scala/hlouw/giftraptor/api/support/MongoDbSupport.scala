package hlouw.giftraptor.api.support

import reactivemongo.api.Collection

trait MongoDbSupport {

  def collection(name: String): Collection
}
