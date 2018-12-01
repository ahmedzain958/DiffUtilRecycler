package com.zain.diffutilrecycler

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(val dataSource: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myTextView.text = dataSource.get(holder.adapterPosition)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_item, viewGroup, false)
        return MyViewHolder(itemView)
    }

    fun insertItem(newList: List<String>) {
        val diffUtilCallbaclk = MyDiffUtilCallback(dataSource, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallbaclk)
        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateItem(newList: List<String>) {
        val diffUtilCallbaclk = MyDiffUtilCallback(dataSource, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallbaclk)
        dataSource.clear()
        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var myTextView: TextView

        init {
            this.myTextView = itemView.findViewById(R.id.txt_text)
        }
    }

}