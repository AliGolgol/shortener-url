package com.urlshortener.codechallenge.infrastructure.controller

import com.urlshortener.codechallenge.usecase.createshortenerurl.CreateShortenerUrl
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(ShortenerController::class)
class ShortenerControllerTest {
    private val BASE_URL = "/api/v1"

    @MockBean
    lateinit var createShortenerUrl: CreateShortenerUrl

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `should return shortener url for given url`() {
        val original = "http://dkb-code.com"
        val expected = "http://shortener.com/1"

        whenever(createShortenerUrl.create(original)).thenReturn(expected)
        mvc.perform(
            post("${BASE_URL}/data/shorten")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createdPayload())
                .characterEncoding("utf-8")
        )
            .andExpect(status().`is`(HttpStatus.CREATED.value()))

    }

    @Test
    fun `should return original url for given shortener url`() {
        val original = "http://dkb-code.com"
        val shortUrl = "http://shortener.com/1"

        whenever(createShortenerUrl.get(shortUrl)).thenReturn(original)
        mvc.perform(
            get("${BASE_URL}/shortUrl?url=${original}")
                .content(createdPayload())
                .characterEncoding("utf-8")
        )
            .andExpect(status().`is`(HttpStatus.OK.value()))
    }

    private fun createdPayload(): String {
        return """
            {
                "url": "http://dkb-code.com"
            }""".trimMargin()
    }
}