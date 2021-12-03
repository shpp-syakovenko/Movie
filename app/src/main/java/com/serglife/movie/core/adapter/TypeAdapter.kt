package com.serglife.movie.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter


open class TypeAdapter(private val factory: TypeItemsFactory) :
    ListAdapter<TypeDataHolder, TypeViewHolder>(TypeItemsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        factory.createViewHolder(parent.context, parent, viewType)


    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        factory.bindHolders(holder, currentList[position])
    }

    override fun getItemViewType(position: Int) =
        factory.getDataHolderType(currentList[position])

    override fun getItemCount() = currentList.size

    fun setEventHolder(eventHolder: TypeEventsHolder, type: Int){
        factory.attachEventHolder(eventHolder, type)
    }
}