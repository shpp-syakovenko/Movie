package com.serglife.movie.core.adapter

import android.content.Context
import android.view.ViewGroup

abstract class TypeItemsFactory {

    protected val eventHolders = HashMap<Int, TypeEventsHolder>()

    fun attachEventHolder(eventHolder: TypeEventsHolder, type: Int){
        eventHolders[type] = eventHolder
    }

    abstract fun getDataHolderType(holder: TypeDataHolder): Int

    abstract fun bindHolders(viewHolder: TypeViewHolder, dataHolder: TypeDataHolder)

    abstract fun createViewHolder(context: Context?, parentView: ViewGroup,type: Int): TypeViewHolder

}