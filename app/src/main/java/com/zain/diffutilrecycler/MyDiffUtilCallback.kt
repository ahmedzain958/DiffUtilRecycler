package com.zain.diffutilrecycler

import android.support.v7.util.DiffUtil

class MyDiffUtilCallback(
    private val oldList: List<String>,
    private val newList: List<String>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldPosition == newPosition
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition] == newList[newPosition]
    }

}
