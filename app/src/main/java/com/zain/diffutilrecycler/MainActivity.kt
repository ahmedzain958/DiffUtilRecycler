package com.zain.diffutilrecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    internal var dataSource: MutableList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        recycler.setHasFixedSize(true)
        recycler.layoutManager = (LinearLayoutManager(this))

        val adapter = MyAdapter(dataSource)
        recycler.setAdapter(adapter)
        insert_btn.setOnClickListener({
            val insertedList = ArrayList<String>()
            for (i in 0..2)
                insertedList.add(UUID.randomUUID().toString())
            adapter.insertItem(insertedList)
            recycler.smoothScrollToPosition(adapter.itemCount - 1)
        })
        update_btn.setOnClickListener({
            val updatedList = ArrayList<String>()
            for (i in 0..2)
                updatedList.add(UUID.randomUUID().toString())
            adapter.updateItem(updatedList)
        })
    }

    private fun initData() {
        for (i in 0..2) {
            dataSource.add(UUID.randomUUID().toString())
        }
    }
}

