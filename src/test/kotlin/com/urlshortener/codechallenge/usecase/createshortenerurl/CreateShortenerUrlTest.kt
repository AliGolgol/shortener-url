package com.urlshortener.codechallenge.usecase.createshortenerurl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CreateShortenerUrlTest {

    @Autowired
    private val createShortenerUrl = CreateShortenerUrl()

    @Test
    fun `should return shortener url for given url`() {
        val original = "http://dkb-code.com"
        val actual = createShortenerUrl.create(original)
        val expected = "http//shortener.com/1"

        assertEquals(actual, expected)
    }
}