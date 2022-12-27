package com.urlshortener.codechallenge.tools

import org.apache.commons.validator.routines.UrlValidator

class UrlValidationExtension {
    companion object UrlValidation {
        fun String.isValidUrl() {
            val validator = UrlValidator()
            if (!validator.isValid(this))
                throw IllegalArgumentException()
        }
    }
}