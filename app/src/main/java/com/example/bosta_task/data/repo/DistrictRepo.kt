package com.example.bosta_task.data.repo

import com.example.bosta_task.data.api.ApiService
import com.example.bosta_task.data.model.District

class DistrictRepo(private val apiService: ApiService) {
    suspend fun getDistricts(countryId: String): List<District> {
        val response = apiService.getAllDistricts(countryId)
        if (response.success) {
            // Flatten the list of districts from all cities
            return response.data.flatMap { it.districts }
        } else {
            throw Exception(response.message)
        }
    }
}