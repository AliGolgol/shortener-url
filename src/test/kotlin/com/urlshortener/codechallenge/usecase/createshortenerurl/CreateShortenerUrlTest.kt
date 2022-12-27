package com.urlshortener.codechallenge.usecase.createshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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

        val expected = "http://shortener.com/1"

        assertEquals(actual, expected)
    }

    @Test
    fun `should throw exception for given url`() {
        val original = "http://dkb-code.com/iv143#\$@# df"

        assertThrows<IllegalArgumentException> {
            createShortenerUrl.create(original)
        }
    }

    @Test
    fun `should return original url for given shortener url`() {
        val original = "http://dkb-code.com"
        val shortener = Shortener()
        val shortUrl = shortener.encode(original)

        val actual = createShortenerUrl.get(shortUrl)

        assertEquals(original, actual)
    }

    @Test
    fun `should throw exception for given long url`() {
        val original = "http://dkb-code.com/iv143#\$@# df"

        assertThrows<IllegalArgumentException> {
            createShortenerUrl.get(original)
        }
    }
}