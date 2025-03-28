package com.dixa.analytics.model

enum Direction(val value: String):
  case Inbound  extends Direction("inbound")
  case Outbound extends Direction("outbound")
