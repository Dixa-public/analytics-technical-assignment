package com.dixa.analytics.model

enum Channel(val value: String):
  case Email extends Channel("email")
  case Chat  extends Channel("chat")
  case Phone extends Channel("phone")
