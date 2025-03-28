package com.dixa.analytics

import cats.effect.{IO, Resource}
import com.dixa.analytics.dao.AggregateQueryDao
import weaver.IOSuite

object AggregateQueryDaoTest extends IOSuite {

  override type Res = AggregateQueryDao
  override def sharedResource: Resource[IO, AggregateQueryDao] = AggregateQueryDao.create

  test("count the number of conversations") { db =>
    db.conversationCount.map(count => expect.same(5000, count))
  }

}
