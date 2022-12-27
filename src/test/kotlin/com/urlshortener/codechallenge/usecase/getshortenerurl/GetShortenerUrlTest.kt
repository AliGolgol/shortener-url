package com.urlshortener.codechallenge.usecase.getshortenerurl

import com.urlshortener.codechallenge.domain.Shortener
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class GetShortenerUrlTest {
    @Autowired
    private val getShortenerUrl = GetShortenerUrl()

    @Test
    fun `should return original url for given shortener url`() {
        val original = "http://dkb-code.com"
        val shortener = Shortener()
        val shortUrl = shortener.encode(original)

        val actual = getShortenerUrl.get(shortUrl)
        val expected = "http://shortener.com/1"

        assertEquals(expected, actual)
    }

    @Test
    fun `should throw exception for given url`() {
        val original = "http://dkb-code.com/iv143#\$@# df"

        assertThrows<IllegalArgumentException> {
            getShortenerUrl.get(original)
        }
    }
}