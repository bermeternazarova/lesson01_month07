package com.example.lesson01_month07.presentation.ui.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson01_month07.databinding.ItemNoteBinding
import com.example.lesson01_month07.domain.model.NOte

class AdapterNotes(private val click:(NOte)->Unit,
                   private val onLongClick:(NOte)->Unit)
    :ListAdapter<NOte,AdapterNotes.ViewHolderNotes>(
    DFUtilCallBack()
    ){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNotes {
        return ViewHolderNotes(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderNotes, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderNotes (
        private val binding: ItemNoteBinding
        ):RecyclerView.ViewHolder(binding.root){
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
@SuppressLint("DiffUtilEquals")
private class DFUtilCallBack :DiffUtil.ItemCallback<NOte>(){
    override fun areItemsTheSame(oldItem: NOte, newItem: NOte): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: NOte, newItem: NOte): Boolean {
        return oldItem==newItem
    }
}