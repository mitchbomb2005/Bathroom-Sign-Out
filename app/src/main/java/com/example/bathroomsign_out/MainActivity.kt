package com.example.bathroomsign_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.github.kittinunf.fuel.Fuel
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val button: Button = findViewById(R.id.button)
        var selectedname = "no teacher selected"
        var ed1 = findViewById<EditText>(R.id.nameinput)
        var fullname = ed1.text

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var name = spinner.selectedItemPosition
                when (name) {
                    0 -> selectedname = "Scott"
                    1 -> selectedname = "Tierney"
                    2 -> selectedname = "Avcollie"
                    3 -> selectedname = "Johnson"
                    4 -> selectedname = "Fuller"
                    5 -> selectedname = "Erikson"
                    6 -> selectedname = "Maslak"
                    7 -> selectedname = "Foulds"
                    8 -> selectedname = "Miller"
                    9 -> selectedname = "Sconz"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{
            Fuel.get("https://thatpenguin.net/bathroom?n=$fullname&p=$selectedname")
                .response { request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes] ${String(bytes)}")
                    }
                }
            val toast = Toast.makeText(this, "Success!", Toast.LENGTH_SHORT)
            toast.show();
            Thread.sleep(300)
            finish();
            //exitProcess(0);
        }
    }

}