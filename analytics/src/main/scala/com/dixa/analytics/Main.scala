package com.dixa.analytics

import cats.implicits.toFlatMapOps
import cats.effect.{IO, Resource, ResourceApp}
import com.dixa.analytics.Processor.processEvents
import com.dixa.analytics.dao.IngestionDao
import com.dixa.analytics.generator.EventStream
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger
import scala.concurrent.duration.*

object Main extends ResourceApp.Simple:

  given logger: Logger[IO] = Slf4jLogger.getLogger[IO]

  def run: Resource[IO, Unit] = for
    _           <- Resource.eval(logger.info("Starting the ingest application"))
    database    <- IngestionDao.create
    eventStream <- Resource.pure(EventStream.generateEventStream)
    _ <- Resource.eval(
      processEvents(database)(eventStream)
        .concurrently(fs2.Stream.fixedRate[IO](3.seconds).evalMap(_ => logger.info("Processing...")))
        .compile
        .drain
    )
    _ <- Resource.eval(logger.info(s"Finished processing the event stream"))
  yield ()
