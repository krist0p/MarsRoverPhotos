package com.example.marsroverphotos.presentation.util

fun String.toHttpsPrefix(): String = if (isNotEmpty() && !startsWith("https://") && !startsWith("http://")) {
    "https://$this"
} else if (startsWith("http://")) {
    replace("http://", "https://")
} else this