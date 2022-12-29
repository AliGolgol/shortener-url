package com.urlshortener.codechallenge.infrastructure.controller

import com.urlshortener.codechallenge.usecase.createshortenerurl.CreateShortenerUrl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ShortenerController(private val createShortenerUrl: CreateShortenerUrl) {

    @PostMapping("/data/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody url: RequestUrl): String = createShortenerUrl.create(url.url)

    @GetMapping("/shortUrl")
    @ResponseStatus(HttpStatus.OK)
    fun get(@RequestParam url: String): String? = createShortenerUrl.get(url)
    data class RequestUrl(val url: String)
}