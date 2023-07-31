package com.surajrathod.kotlinmultiplatformdemo

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"+"\n ${daysUntilNewYear()}"
    }
}