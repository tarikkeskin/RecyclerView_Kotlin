package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var filmlerListesi:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1,"Django","django",12.99)
        val f2 = Filmler(2,"Django","thehatefuleight",12.99)
        val f3 = Filmler(3,"Django","anadoluda",12.99)
        val f4 = Filmler(4,"Django","interstellar",12.99)
        val f5 = Filmler(5,"Pianist","thepianist",12.99)
        val f6 = Filmler(6,"Inception","inception",12.99)
        filmlerListesi = ArrayList<Filmler>()
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        adapter = FilmlerAdapter(this,filmlerListesi)
        rv.adapter = adapter

    }
}