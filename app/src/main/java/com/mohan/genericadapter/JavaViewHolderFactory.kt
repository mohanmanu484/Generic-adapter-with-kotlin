package com.kasturi.admin.genericadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by mohang on 12/12/17.
 */

object JavaViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.car_layout -> CarViewHolder(view)
            R.layout.bus_layout -> BusViewHolder(view)
            else -> {
                CarViewHolder(view)
            }
        }
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Car> {

        var textView: TextView
        init {
            textView = itemView.findViewById(R.id.carName)
        }
        override fun bind(car: Car) {
            textView.text = car.name
        }
    }

    class BusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Bus> {

        var textView: TextView
        init {
            textView = itemView.findViewById(R.id.busName)
        }
        override fun bind(bus: Bus) {
            textView.setText(bus.name)
        }
    }
}
