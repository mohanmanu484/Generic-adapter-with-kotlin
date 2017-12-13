package com.kasturi.admin.genericadapter

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val list= listOf<Any>(Car("audi",Color.BLACK),Bus("Eicher",Color.BLUE),Bus("Benz",Color.BLACK),Car("Suzuki",Color.WHITE))

        val myAdapter = object : GenericAdapter<Any>(list) {
            override fun getLayoutId(position: Int, obj: Any): Int {
                return when(obj){
                    is Car->R.layout.car_layout
                    is Bus->R.layout.bus_layout
                    else->R.layout.car_layout
                }
            }

            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return JavaViewHolderFactory.create(view,viewType)
            }
        }
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=myAdapter
    }

}
