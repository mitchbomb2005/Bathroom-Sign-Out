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
                val teachers = resources.getStringArray(R.array.brew_array).toList()
                when (name) {
                    0 -> selectedname = teachers[0]
                    1 -> selectedname = teachers[1]
                    2 -> selectedname = teachers[2]
                    3 -> selectedname = teachers[3]
                    4 -> selectedname = teachers[4]
                    5 -> selectedname = teachers[5]
                    6 -> selectedname = teachers[6]
                    7 -> selectedname = teachers[7]
                    8 -> selectedname = teachers[8]
                    9 -> selectedname = teachers[9]
                    10 -> selectedname = teachers[10]
                    11 -> selectedname = teachers[11]
                    12 -> selectedname = teachers[12]
                    13 -> selectedname = teachers[13]
                    14 -> selectedname = teachers[14]
                    15 -> selectedname = teachers[15]
                    16 -> selectedname = teachers[16]
                    17 -> selectedname = teachers[17]
                    18 -> selectedname = teachers[18]
                    19 -> selectedname = teachers[19]
                    20 -> selectedname = teachers[20]
                    21 -> selectedname = teachers[21]
                    22 -> selectedname = teachers[22]
                    23 -> selectedname = teachers[23]
                    24 -> selectedname = teachers[24]
                    25 -> selectedname = teachers[25]
                    26 -> selectedname = teachers[26]
                    27 -> selectedname = teachers[27]
                    28 -> selectedname = teachers[28]
                    29 -> selectedname = teachers[29]
                    30 -> selectedname = teachers[30]
                    31 -> selectedname = teachers[31]
                    32 -> selectedname = teachers[32]
                    33 -> selectedname = teachers[33]
                    34 -> selectedname = teachers[34]
                    35 -> selectedname = teachers[35]
                    36 -> selectedname = teachers[36]
                    37 -> selectedname = teachers[37]
                    38 -> selectedname = teachers[38]
                    39 -> selectedname = teachers[39]
                    40 -> selectedname = teachers[40]
                    41 -> selectedname = teachers[41]
                    42 -> selectedname = teachers[42]
                    43 -> selectedname = teachers[43]
                    44 -> selectedname = teachers[44]
                    45 -> selectedname = teachers[45]
                    46 -> selectedname = teachers[46]
                    47 -> selectedname = teachers[47]
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
                    val (bytes, _) = result
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