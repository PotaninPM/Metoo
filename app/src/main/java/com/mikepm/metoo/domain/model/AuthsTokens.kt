package com.mikepm.metoo.domain.model

data class AuthTokens(
    val accessToken: String,
    val tokenType: String = "bearer"
)