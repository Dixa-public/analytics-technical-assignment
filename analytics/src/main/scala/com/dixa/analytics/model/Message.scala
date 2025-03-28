package com.dixa.analytics.model

import java.time.Instant
import java.util.UUID

// Represents a message in a conversation, written by either the customer/end user or the agent
case class Message(
    id: Long,
    conversationId: Long,
    createdAt: Instant,
    direction: Direction,
    body: String,
    author: UUID
) extends Event
