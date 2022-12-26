package com.urlshortener.codechallenge.usecase.createshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import org.springframework.stereotype.Service

@Service
class CreateShortenerUrl {
    private val shortener = Shortener()
    fun create(original: String): String = shortener.encode(original)

}