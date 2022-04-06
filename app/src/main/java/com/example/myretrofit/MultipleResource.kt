package com.example.myretrofit

import com.google.gson.annotations.SerializedName

class MultipleResource {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("per_page")
    var perPage: Int? = null

    @SerializedName("total")
    var total: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("data")
    var data: List<Data>? = null

    class Data{
        @SerializedName("id")
        var id: Int? = 0
        var email: String= ""

        @SerializedName("first_name")
        var firstName: String= ""

        @SerializedName("last_name")
        var lastName: String= ""

        @SerializedName("avatar")
        var avatar: String? = null
    }
}