package com.urlshortener.codechallenge.infrastructure.controller

import com.urlshortener.codechallenge.usecase.createshortenerurl.CreateShortenerUrl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ShortenerController(private val createShortenerUrl: CreateShortenerUrl) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody url: RequestUrl): String {
        return createShortenerUrl.create(url.url)
    }

    data class RequestUrl(val url: String)
}