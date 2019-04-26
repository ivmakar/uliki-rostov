package ru.example.ivan.ulikirostov


import androidx.databinding.ObservableInt
import java.io.Serializable

class Item : Serializable {
    var id = 0
    var name = String()
    var description = String()
    var count: ObservableInt = ObservableInt()
    var price: ObservableInt = ObservableInt()

    constructor (id: Int, name: String, description: String, count: Int, price: Int){
        this.id = id
        this.name = name
        this.description = description
        this.count.set(count)
        this.price.set(price)
    }


    fun onButtonAddClick(){
        count.set(count.get() + 1)
    }

    fun onButtonRemClick(){
        count.set(count.get() - 1)
        if (count.get() < 0)
            count.set(0)
    }

    fun onButtonClrClick(){
        count.set(0)
    }
}