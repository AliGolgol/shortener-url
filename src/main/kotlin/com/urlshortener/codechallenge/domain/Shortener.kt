package com.urlshortener.codechallenge.domain

class Shortener {
    private var index = 1L
    private var indexToUrl = HashMap<Long, String>()
    private var urlToIndex = HashMap<String, Long>()
    private var base62Characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val BASE_URL = "http//shortener.com/"

    fun encode(originalUrl: String?): String {
        return if (urlToIndex.containsKey(originalUrl)) {
            BASE_URL + base62Encode(urlToIndex[originalUrl]!!)
        } else {
            indexToUrl[index] = originalUrl!!
            urlToIndex[originalUrl] = index
            index++
            BASE_URL + base62Encode(urlToIndex[originalUrl]!!)
        }
    }

    private fun base62Encode(value: Long): String {
        var currentValue = value
        val sb = StringBuilder()
        while (currentValue != 0L) {
            sb.append(base62Characters[(currentValue % 62).toInt()])
            currentValue /= 62
        }
        return sb.reverse().toString()
    }
}