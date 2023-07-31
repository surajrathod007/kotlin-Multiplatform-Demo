package com.surajrathod.kotlinmultiplatformdemo

import com.surajrathod.kotlinmultiplatformdemo.model.UsersItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Greeting {

    private val platform: Platform = getPlatform()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    fun greet(): String {
        return "Hello, ${platform.name}!" + "\n ${daysUntilNewYear()}"
    }

    suspend fun loadData() : List<UsersItem>{
        val list: List<UsersItem> =
            httpClient.get("https://jsonplaceholder.typicode.com/users").body()
        return list
    }

    fun userToJson(usersItem: UsersItem) : String{
        return Json.encodeToString(usersItem)
    }

    fun jsonToUser(data : String) : UsersItem{
        return Json.decodeFromString<UsersItem>(data)
    }

}