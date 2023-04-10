package com.example.lesson01_month07.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson01_month07.databinding.ItemNoteBinding
import com.example.lesson01_month07.domain.model.NOte

class AdapterNotes(private val click:(NOte)->Unit,
private val onLongClick:(NOte)->Unit):RecyclerView.Adapter<AdapterNotes.ViewHolderNotes>() {

    private val list = arrayListOf<NOte>()

    fun addNotes(newList: List<NOte>){
        list.clear()
        list.reversed()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNotes {
        return ViewHolderNotes(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderNotes, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolderNotes (private val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(nOte: NOte) {
            binding.tvTitle.text=nOte.title.toString()
            binding.description.text=nOte.desc.toString()
            itemView.setOnClickListener {
                click(nOte)
            }
            itemView.setOnLongClickListener {
                onLongClick(nOte)
                return@setOnLongClickListener false
            }
        }

    }
}