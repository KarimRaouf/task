package com.example.bosta_task.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bosta_task.data.model.District
import com.example.bosta_task.data.repo.DistrictRepo
import kotlinx.coroutines.launch

class DistrictViewModel(private val repository: DistrictRepo) : ViewModel() {
    private val _districts = MutableLiveData<List<District>>()
    val districts: LiveData<List<District>> get() = _districts

    fun loadDistricts(countryId: String) {
        viewModelScope.launch {
            try {
                val result = repository.getDistricts(countryId)
                _districts.value = result
            } catch (e: Exception) {
                // Handle error (e.g., show a message to the user)
            }
        }
    }
}