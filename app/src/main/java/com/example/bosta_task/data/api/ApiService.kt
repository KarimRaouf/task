package com.example.bosta_task.data.api

import com.example.bosta_task.data.model.District
import com.example.bosta_task.data.model.Root
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("cities/getAllDistricts")
    suspend fun getAllDistricts(@Query("countryId") countryId: String): Root
}

class  ApiServiceFactory{

}