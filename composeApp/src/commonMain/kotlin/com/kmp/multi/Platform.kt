package com.kmp.multi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform