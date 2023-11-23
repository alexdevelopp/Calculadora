package com.example.recicledview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PeliculasViewHolder(vista: View):RecyclerView.ViewHolder(vista) {
    val titulo = vista.findViewById(R.id.titulo) as TextView
    val descripcion = vista.findViewById(R.id.descripcion) as TextView

    fun bind(peli:RecycledViewActivity.Pelicula,eventListener: (RecycledViewActivity.Pelicula,View) -> Unit) {
        titulo.text = peli.titulo
        descripcion.text = peli.descripcion
        itemView.setOnClickListener{eventListener(peli,itemView)}
    }


}

class PeliculasAdapter(var listaPeliculas:List<RecycledViewActivity.Pelicula>,val eventListener:(RecycledViewActivity.Pelicula, View) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vista = inflater.inflate(R.layout.my_cell,parent,false)
        return PeliculasViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PeliculasViewHolder).bind(listaPeliculas[position], eventListener)
    }

}