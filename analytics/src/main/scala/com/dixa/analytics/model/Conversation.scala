package com.dixa.analytics.model

import java.time.Instant
import java.util.UUID

case class Conversation(
    id: Long,
    createdAt: Instant,
    initialDirection: Direction,
    channel: Channel,
    contact: UUID,         // End user
    assignee: Option[UUID] // Agent
) extends Event
