package com.example.recicledview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recicledview.databinding.ActivityRecycledViewBinding

class RecycledViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecycledViewBinding
    val listaPeliculas = ArrayList<Pelicula>()
    data class Pelicula (val titulo: String, val descripcion: String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycledViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.vistaReciclada.layoutManager = LinearLayoutManager(this)
        crearListaPeliculas()
    }

    fun crearListaPeliculas (){
        listaPeliculas.add(Pelicula("Django","Vaquero desenfrenado."))
        listaPeliculas.add(Pelicula("Matrix","Revelion contra las maquinas"))
        listaPeliculas.add(Pelicula("Titanic","Se ahogan todos (creo)"))
        binding.vistaReciclada.adapter = PeliculasAdapter(listaPeliculas,{pelicula, view ->  })
    }

    private fun peliculaClicked(pelicula:Pelicula,v: View){
        listaPeliculas.remove(pelicula)
        val position = binding.vistaReciclada.getChildAdapterPosition(v)
        binding.vistaReciclada.adapter?.notifyItemRemoved(position)
    }

}