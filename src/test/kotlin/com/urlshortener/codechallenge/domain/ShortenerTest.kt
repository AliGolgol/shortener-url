package com.urlshortener.codechallenge.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShortenerTest {

    val BASE_URL = "http//shortener.com/"

    @Test
    fun `should return shortener for given long url`() {
        val shortener = Shortener()
        val originalUrl = "dkb-code.com"
        val actual = shortener.encode(originalUrl)
        val expected = "${BASE_URL}1"
        assertEquals(actual, expected)
    }
}