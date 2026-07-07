package com.example.zeppedapp.data.remote.api

import com.example.zeppedapp.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val ktorClient = HttpClient(Android) {//Creación del cliente global

    //repuesta y petición
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            isLenient = true
        })
    }
    //registro peticiones
    install(Logging) {
        level = LogLevel.ALL
    }
    //peticiones predeterminadas
    defaultRequest {
        url(Constants.BASE_URL)
        contentType(ContentType.Application.Json)
        headers.append("apikey", Constants.API_KEY)
        headers.append("Authorization", "Bearer ${Constants.API_KEY}")
    }
}