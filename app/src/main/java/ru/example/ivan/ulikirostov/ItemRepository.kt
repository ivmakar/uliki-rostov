package ru.example.ivan.ulikirostov

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class ItemRepository {

    fun getItems() : Observable<ArrayList<Item>> {
        var arrayList = ArrayList<Item>()
        arrayList.add(Item(1, "Д1М1-12", "Улей Дадана однокорпусный с магазином 12 рамок (Комплект Д1М1-12)", 0, 2550))
        arrayList.add(Item(2, "Д1М2-12", "Улей Дадана однокорпусный с 2 магазинами 12 рамок (Комплект Д1М2-12)", 0, 3100))
        arrayList.add(Item(3, "Д1М3-12", "Улей Дадана однокорпусный с 3 магазинами 12 рамок (Комплект Д1М3-12)", 0, 3650))
        arrayList.add(Item(4, "Д1М4-12", "Улей Дадана однокорпусный с 4 магазинами 12 рамок (Комплект Д1М4-12)", 0, 4200))
        arrayList.add(Item(5, "Д2М1-12", "Улей Дадана двухкорпусный с магазином 12 рамок (Комплект Д2М1-12)", 0, 3000))
        arrayList.add(Item(6, "Д2М2-12", "Улей Дадана двухкорпусный с 2 магазинами 12 рамок (Комплект Д2М2-12)", 0, 3850))
        arrayList.add(Item(7, "Д1К-12", "Улей Дадана однокорпусный с кормушкой 12 рамок (Комплект Д1К-12)", 0, 2750))
        arrayList.add(Item(8, "Д2К-12", "Улей Дадана двухкорпусный с кормушкой 12 рамок (Комплект Д2К-12)", 0, 3500))
        arrayList.add(Item(9, "Д2-12", "Улей Дадана двухкорпусный 12 рамок (Комплект Д2-12)", 0, 2750))
        arrayList.add(Item(10, "Д3-12", "Улей Дадана трёхкорпусный 12 рамок (Комплект Д3-12)", 0, 3500))
        arrayList.add(Item(11, "Д1-12", "Улей Дадана однокорпусный 12 рамок (комплект Д1-12)", 0, 2000))
        arrayList.add(Item(12, "Д1-10", "Улей Дадана однокорпусный 10 рамок (комплект Д1-10)", 0, 1850))
        arrayList.add(Item(13, "Д3-10", "Улей Дадана трёхкорпусный 10 рамок (Комплект Д3-10)", 0, 3250))
        arrayList.add(Item(14, "Д2-10", "Улей Дадана двухкорпусный 10 рамок (Комплект Д2-10)", 0, 2550))
        arrayList.add(Item(15, "Р3К-10", "Улей Рута трёхкорпусный с кормушкой 10 рамок (Комплект Р3К-10)", 0, 3800))
        arrayList.add(Item(16, "Р3-10", "Улей Рута трёхкорпусный 10 рамок (Комплект Р3-10)", 0, 3100))
        arrayList.add(Item(17, "Д2К-10", "Улей Дадана двухкорпусный с кормушкой 10 рамок (Комплект Д2К-10)", 0, 3250))
        arrayList.add(Item(18, "Д1К-10", "Улей Дадана однокорпусный с кормушкой 10 рамок (Комплект Д1К-10)", 0, 2550))
        arrayList.add(Item(19, "Д2М2-10", "Улей Дадана двухкорпусный с 2 магазинами 10 рамок (Комплект Д2М2-10)", 0, 3550))
        arrayList.add(Item(20, "Д2М1-10", "Улей Дадана двухкорпусный с магазином 10 рамок (Комплект Д2М1-10)", 0, 3050))
        arrayList.add(Item(21, "Д1Р2-10", "Улей Дадана-Рута трёхкорпусный 10 рамок (Комплект Д1Р2-10)", 0, 3150))
        arrayList.add(Item(22, "Д1Р1-10", "Улей Дадана-Рута двухкорпусный 10 рамок (Комплект Д1Р1-10)", 0, 2500))
        arrayList.add(Item(23, "Д1М4-10", "Улей Дадана однокорпусный с 4 магазинами 10 рамок (Комплект Д1М4-10)", 0, 3850))
        arrayList.add(Item(24, "Д1М3-10", "Улей Дадана однокорпусный с 3 магазинами 10 рамок (Комплект Д1М3-10)", 0, 3350))
        arrayList.add(Item(25, "Д1М2-10", "Улей Дадана однокорпусный с 2 магазинами 10 рамок (Комплект Д1М2-10)", 0, 3850))
        arrayList.add(Item(26, "Д1М1-10", "Улей Дадана однокорпусный с магазином 10 рамок (Комплект Д1М1-10)", 0, 2350))

        return Observable.just(arrayList)
    }
}