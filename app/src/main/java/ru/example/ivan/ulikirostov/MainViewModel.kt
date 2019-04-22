package ru.example.ivan.ulikirostov

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    var items = MutableLiveData<ArrayList<Item>>()
    var isLoading = ObservableBoolean()
    var sumPrice = ObservableInt()
    var selrctedItems = ArrayList<Item>()

    private var compositeDisposable = CompositeDisposable()
    private var itemRepository = ItemRepository()

    init{
        loadItems()
    }

    private fun loadItems(){
        isLoading.set(true)
        compositeDisposable.add(itemRepository
            .getItems()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableObserver<ArrayList<Item>>() {


                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onNext(t: ArrayList<Item>) {
                    items.value = t
                }

                override fun onComplete() {
                    isLoading.set(false)
                }

            })
        )
    }

    fun calculatePrice (){
        selrctedItems.clear()
        sumPrice.set(0)
        for (i in items.value!!){
            if (i.count.get() > 0){
                selrctedItems.add(i)
                sumPrice.set(sumPrice.get() + i.count.get()*i.price.get())
            }
        }
    }

    fun clearAll(){
        loadItems()
    }

    fun shareData(): String {
        var res = StringBuilder()
        for (i in selrctedItems){
            res.append(i.name)
                .append("\t\t")
                .append(i.count.get())
                .append("*")
                .append(i.price.get())
                .append(" = ")
                .append(i.count.get() * i.price.get())
                .append("\n")
        }
        res.append("\nИтог\t\t\t\t")
            .append(sumPrice.get())
            .append("\n\nuliki-rostov.ru\n")

        return res.toString()
    }

    fun getItemByPosition (position: Int) = items.value?.get(position)

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}