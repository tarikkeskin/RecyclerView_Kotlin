package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context,private val filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimNesneleriniTutucu>() {

    inner class CardTasarimNesneleriniTutucu(view: View):RecyclerView.ViewHolder(view){
        var imageViewFilmResim:ImageView
        var textViewFilmBaslik:TextView
        var textViewFilmFiyat:TextView
        var buttonSepeteEkle:Button

        init {
            imageViewFilmResim = view.findViewById(R.id.imageViewFilmResim)
            textViewFilmBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFilmFiyat = view.findViewById(R.id.textViewFilmFiyat)
            buttonSepeteEkle = view.findViewById(R.id.button)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : CardTasarimNesneleriniTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_film_tasarimi,parent,false)
        return CardTasarimNesneleriniTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {
        var film = filmlerListesi[position]

        holder.textViewFilmBaslik.text = film.film_ad
        holder.textViewFilmFiyat.text = "${film.film_fiyat } ₺"

        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim_ad,"drawable",mContext.packageName))

        holder.buttonSepeteEkle.setOnClickListener {
            Toast.makeText(mContext,"sepete eklendi",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}