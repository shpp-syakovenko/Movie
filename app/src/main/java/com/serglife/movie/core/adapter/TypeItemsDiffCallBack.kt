package com.serglife.movie.core.adapter

import androidx.recyclerview.widget.DiffUtil

class TypeItemsDiffCallBack: DiffUtil.ItemCallback<TypeDataHolder>() {
    override fun areItemsTheSame(oldItem: TypeDataHolder, newItem: TypeDataHolder): Boolean {
        return oldItem.areItemTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: TypeDataHolder, newItem: TypeDataHolder): Boolean {
        return oldItem.areContentTheSame(newItem)
    }
}