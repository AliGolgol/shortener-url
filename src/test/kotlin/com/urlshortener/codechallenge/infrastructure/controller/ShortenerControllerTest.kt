package com.urlshortener.codechallenge.infrastructure.controller

import com.urlshortener.codechallenge.usecase.createshortenerurl.CreateShortenerUrl
import com.urlshortener.codechallenge.usecase.getshortenerurl.GetShortenerUrl
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
            post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(createdPayload())
                .characterEncoding("utf-8")
        )
            .andExpect(status().`is`(HttpStatus.CREATED.value()))

    }

    private fun createdPayload(): String {
        return """
            {
                "url": "http://dkb-code.com"
            }""".trimMargin()
    }
}