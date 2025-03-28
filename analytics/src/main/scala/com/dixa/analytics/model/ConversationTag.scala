package com.dixa.analytics.model

import java.time.Instant
import java.util.UUID

// Represents a tag associated with a conversation, e.g. "spam", "important"
// A conversation can have 0..N tags associated with it
case class ConversationTag(
    tagId: UUID,
    createdAt: Instant,
    conversationId: Long,
    tagName: String
) extends Event
