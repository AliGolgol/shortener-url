package com.urlshortener.codechallenge.usecase.createshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import com.urlshortener.codechallenge.tools.UrlValidationExtension.UrlValidation.isValidUrl
import org.springframework.stereotype.Service

@Service
class CreateShortenerUrl {
    private val shortener = Shortener()
    fun create(original: String): String {
        original.isValidUrl()
        return shortener.encode(original)
    }

    fun get(shortUrl: String): String? {
        shortUrl.isValidUrl()
        return shortener.decode(shortUrl)
    }
}