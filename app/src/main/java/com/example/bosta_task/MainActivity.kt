package com.example.bosta_task
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bosta_task.data.api.ApiService
import com.example.bosta_task.data.repo.DistrictRepo
import com.example.bosta_task.databinding.ActivityMainBinding
import com.example.bosta_task.di.AppModule
import com.example.bosta_task.presentation.adapter.DistrictAdapter
import com.example.bosta_task.presentation.viewmodel.DistrictViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DistrictViewModel
    private lateinit var adapter: DistrictAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        adapter = DistrictAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        var retrofit = AppModule().provideApiService()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofit.getAllDistricts("60e4482c7cb7d4bc4849c4d5")
                Log.d("API_RESPONSE", response.toString())  // Handle the response
            } catch (e: Exception) {
                Log.e("API_ERROR", "Error fetching data: ${e.message}")
            }
        }
        // Initialize ViewModel
//        viewModel = ViewModelProvider(this).get(DistrictViewModel::class.java)
//
//        // Observe data
//        viewModel.districts.observe(this, Observer {
//            adapter.submitList(it)
//        })
//
//        // Load data
//        viewModel.loadDistricts("60e4482c7cb7d4bc4849c4d5")
    }
}