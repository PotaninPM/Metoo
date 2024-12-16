package com.mikepm.metoo.domain.repository

import com.mikepm.metoo.domain.model.AuthTokens
import com.mikepm.metoo.domain.model.LoginUser
import com.mikepm.metoo.domain.model.RegisterUser

interface AuthRepository {
    suspend fun register(credentials: RegisterUser): Result<AuthTokens>
    suspend fun login(credentials: LoginUser): Result<AuthTokens>
}