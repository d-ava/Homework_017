package com.example.homework_017drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_017drawer.databinding.ItemBinding

class StuffRecycler : RecyclerView.Adapter<StuffRecycler.StuffViewHolder>() {

    var list = listOf<Stuff>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StuffViewHolder {
        return StuffViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: StuffViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = list.size

    inner class StuffViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Stuff
        fun onBind() {
            model = list[adapterPosition]
            binding.tvText.text = model.stuffName
            binding.Icon.setImageResource(model.drawable)

            if (model.number != null) {
                binding.tvNumber.text = model.number.toString()
            }


        }

    }
}