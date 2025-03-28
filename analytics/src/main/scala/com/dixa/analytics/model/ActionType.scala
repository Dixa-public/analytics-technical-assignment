package com.dixa.analytics.model

enum ActionType[T <: Event]:
  case Insert(event: T)
  case Update(event: T)
  case Delete(event: T)
