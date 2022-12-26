package com.urlshortener.codechallenge.usecase.getshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import org.springframework.stereotype.Service

@Service
class GetShortenerUrl {
    private val shortenerUrl = Shortener()
    fun get(shortUrl: String): String? = shortenerUrl.encode(shortUrl)
}