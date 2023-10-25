package com.SMJV9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var conversion : Int = 0
    private var result : Double = 0.0
    private var value : String = ""
    private lateinit var total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var selectedTemp = findViewById<Spinner>(R.id.spinner)
        var temp = findViewById<EditText>(R.id.temp)
        var button = findViewById<Button>(R.id.convertir)
        total = findViewById(R.id.resul)

        if(selectedTemp != null){
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_option)
            )

            selectedTemp.adapter = adapter
            selectedTemp.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    di: Long)
                {
                  Toast.makeText(this@MainActivity,
                      "Opcion Selecionada: " + position, Toast.LENGTH_SHORT)
                    conversion = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }


            }
        }
        button.setOnClickListener {

          value = temp.text.toString()

            convert(conversion)

       }
    }

    fun convert(_conversion: Int){

        when(_conversion){

            0 ->{
                //F = (C * 9/5) + 32
                result = (value.toDouble() * 9/5) + 32

                total.text = result.toString()
            }
            1->{
                //K = c + 273.15
                result = value.toDouble() + 273.15

                total.text = result.toString()
            }
            2->{
                //C = (F - 32) * 5/9
            }
            3->{
                //K = F + 459.67 / 1.8
                // (F - 32) * 5/9 + 273.15
            }
            4->{
                //c + K - 273.15
            }
            5->{
                //F = (K - 273.15) * 1.8 + 32
            }
        }
    }
}