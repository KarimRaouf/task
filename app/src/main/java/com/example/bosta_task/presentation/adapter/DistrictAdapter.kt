package com.example.bosta_task.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bosta_task.data.model.District
import com.example.bosta_task.databinding.ItemDistrictBinding
import com.example.bosta_task.presentation.adapter.DistrictAdapter.ViewHolder


class DistrictAdapter : ListAdapter<District, DistrictAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemDistrictBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(district: District) {
            binding.districtName.text = "item"
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<District>() {
        override fun areItemsTheSame(oldItem: District, newItem: District): Boolean {
            return oldItem.districtId == newItem.districtId
        }

        override fun areContentsTheSame(oldItem: District, newItem: District): Boolean {
            return oldItem == newItem
        }
    }
}