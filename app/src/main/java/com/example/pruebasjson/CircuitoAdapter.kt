package com.example.pruebasjson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebasjson.Model.Circuito_Modelo
import kotlinx.android.synthetic.main.circuito_layout.view.*

class CircuitoAdapter(val context: Context, val items: ArrayList<Circuito_Modelo>) :RecyclerView.Adapter<CircuitoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //println("-------------------------")
        //println(items.size)
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.circuito_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        //La parte del holder. se corresponde al nombre dado en la clase de "ViewHolder" la del item. en la clase Circuito_modelo
        //println("-------------------------")
        //println(items.size)
        holder.nom_circ.text = item.nom_Cir.toString()
        holder.nom_pais.text = item.nom_Pais
        holder.nom_localidad.text = item.nom_Localidad

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val nom_circ = view.nom_circuit
        val nom_pais = view.nom_pais
        val nom_localidad = view.nom_local
        val url_Foto = "Aqui añadir la URL"
    }
}