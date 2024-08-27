package com.idat.apppt73013468.home.data.network.response

data class TodosResponseItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)