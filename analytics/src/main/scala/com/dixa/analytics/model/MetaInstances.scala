package com.dixa.analytics.model

import doobie.*

import java.time.Instant
import java.util.UUID

object MetaInstances:

  // Meta instances for converting Scala/Java types to SQL types and vice versa
  given Meta[UUID]      = Meta[String].imap(UUID.fromString)(_.toString)
  given Meta[Instant]   = Meta[String].imap(Instant.parse)(_.toString)
  given Meta[Direction] = Meta[String].imap(Direction.valueOf)(_.value)
  given Meta[Channel]   = Meta[String].imap(Channel.valueOf)(_.value)
