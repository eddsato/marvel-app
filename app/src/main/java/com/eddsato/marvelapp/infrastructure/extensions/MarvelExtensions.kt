package com.eddsato.marvelapp.infrastructure.extensions

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5Encrypt(): String {
    val md = MessageDigest.getInstance("MD5")

    return BigInteger(
        1,
        md.digest(toByteArray())
    ).toString(16).padStart(32, '0')
}