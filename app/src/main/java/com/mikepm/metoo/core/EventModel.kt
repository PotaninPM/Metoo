package com.mikepm.metoo.core

data class EventModel(
    val images: List<String>,
    val latitude: Double,
    val longitude: Double,
    val creatorUserName: String,
    val eventTitle: String,
    val eventCategory: String,
    val eventDate: String,
    val eventTime: String,
    val eventLocation: String,
    val regPeopleId: List<Long>
)