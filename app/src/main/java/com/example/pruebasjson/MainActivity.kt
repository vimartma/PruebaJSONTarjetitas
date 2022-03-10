package com.example.pruebasjson

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebasjson.Model.Circuito_Modelo
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instance of users list using the data model class.
        val circuitos: ArrayList<Circuito_Modelo> = ArrayList()

        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val circuits0 = obj.getJSONObject("MRData")

            val circuits1 = circuits0.getJSONObject("CircuitTable")

            val listaCircuitos = circuits1.getJSONArray("Circuits")

            println("---------------")
            println(listaCircuitos.length())
            for (i in 0 until listaCircuitos.length()) {
                val circuito = listaCircuitos.getJSONObject(i)
                println(circuito)

                val id = circuito.getString("circuitId")
                val nombre = circuito.getString("circuitName")
                val localizacion = circuito.getJSONObject("Location")
                val ciudad = localizacion.getString("locality")
                val pais = localizacion.getString("country")

                // Now add all the variables to the data model class and the data model class to the array list.
                val userDetails =
                    Circuito_Modelo(nombre,pais,ciudad,"Aqui foto")
                println("---------------")
                println(nombre)
                circuitos.add(userDetails)
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        val rvCircuito = findViewById<View>(R.id.rvCircuitos) as RecyclerView
        // Initialize contacts

        // Create adapter passing in the sample user data
        val adapter = CircuitoAdapter(this,circuitos)
        // Attach the adapter to the recyclerview to populate items
        rvCircuito.adapter = adapter
        // Set layout manager to position the items
        rvCircuito.layoutManager = LinearLayoutManager(this)
        // That's all!


        println("-------------------------222")
    }


    /**
     * Method to load the JSON from the Assets file and return the object
     */
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("prueba.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}