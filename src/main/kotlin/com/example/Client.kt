package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono
import java.util.UUID

@Client("client")
interface Client {

    @Get("/proxy",

        consumes=["application/json",],
    )
    fun getBaz(
        @Header(value = "X-Correlation-Id") xCorrelationId: UUID = UUID.randomUUID(),

        ): Mono<HttpResponse<String>>
}