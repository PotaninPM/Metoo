package com.mikepm.metoo.core

data class EventModel(
    val creatorUserName: String,
    val eventTitle: String,
    val eventCategory: String,
    val eventDate: String,
    val eventTime: String,
    val eventLocation: String
)