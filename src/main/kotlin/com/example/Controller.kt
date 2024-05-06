package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlinx.coroutines.reactive.awaitFirst

@Controller
class Controller(
    private val client: Client
) {

    @Get(
        "/endpoint",
    )
    suspend fun getEndpoint(): HttpResponse<String> {

        client.getBaz().awaitFirst()
        return HttpResponse.ok()

    }
}