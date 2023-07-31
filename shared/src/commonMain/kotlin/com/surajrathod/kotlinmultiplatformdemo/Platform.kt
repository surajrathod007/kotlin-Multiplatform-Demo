package com.surajrathod.kotlinmultiplatformdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform