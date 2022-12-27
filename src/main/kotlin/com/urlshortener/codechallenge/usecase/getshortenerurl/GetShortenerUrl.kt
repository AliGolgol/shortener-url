package com.urlshortener.codechallenge.usecase.getshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import com.urlshortener.codechallenge.tools.UrlValidationExtension.UrlValidation.isValidUrl
import org.springframework.stereotype.Service

@Service
class GetShortenerUrl {
    private val shortenerUrl = Shortener()
    fun get(shortUrl: String): String? {
        shortUrl.isValidUrl()
        return shortenerUrl.encode(shortUrl)
    }
}