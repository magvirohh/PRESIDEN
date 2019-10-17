package com.example.presiden

import android.os.Bundle
import android.R.layout.simple_list_item_1
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private val a = 7
    private val b = 7
    private val c = 7
    private var lv: ListView? = null
    private var customeAdapter: adapter? = null
    private var imageModelArrayList: ArrayList<gambar>? = null
    private val myImageList = intArrayOf(
        R.drawable.skrn,
        R.drawable.shrt,
        R.drawable.hbb,
        R.drawable.gsdr,
        R.drawable.mg,
        R.drawable.sby,
        R.drawable.jkw
    )
    private val myImageNameList =
        arrayOf("SUKARNO", "SUHARTO", "BJ.HABIBIE", "GUSDUR", "MEGAWATI", "SUSILO B.Y", "JOKOWI")
    val myImageDesList = arrayOf(
        "Presiden pertama Republik Indonesia, Soekarno yang biasa dipanggil Bung Karno, lahir di Blitar, Jawa Timur, 6 Juni 1901 dan meninggal di Jakarta, 21 Juni 1970",
        "Soeharto adalah Presiden kedua Republik Indonesia. Beliau lahir di Kemusuk, Yogyakarta, tanggal 8 Juni 1921.",
        "Presiden ketiga Republik Indonesia, Bacharuddin Jusuf Habibie lahir di Pare-Pare, Sulawesi Selatan, pada 25 Juni 1936.",
        "Gus Dur adalah putra pertama dari enam bersaudara yang dilahirkan di Denanyar Jombang Jawa Timur pada tanggal 4 Agustus 1940.",
        "Presiden Republik Indonesia ke-5, Megawati Soekarnoputri lahir di Yogyakarta, 23 Januari 1947."
        ,
        "Presiden Susilo Bambang Yudhoyono adalah presiden RI ke-6. Berbeda dengan presiden sebelumnya, beliau merupakan presiden pertama yang dipilih secara langsung oleh rakyat dalam proses Pemilu Presiden putaran II 20 September 2004. Lulusan terbaik AKABRI (1973) yang akrab disapa SBY ini lahir di Pacitan, Jawa Timur 9 September 1949."
        ,
        "Jokowi lahir dengan nama lengkap Joko Widodo. Ia lahir di Surakarta, 21 Juni 1961. Ia merupakan Putera dari pasangan Noto Mihardjo dan Sudhiatmi dan anak sulung dari empat bersaudara."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.listview) as ListView

        imageModelArrayList = populateList()
        Log.d("hjhjh", imageModelArrayList!!.size.toString() + "")
        customeAdapter = adapter(this, imageModelArrayList!!)
        lv!!.adapter = customeAdapter


    }

    private fun populateList(): ArrayList<gambar> {

        val list = ArrayList<gambar>()

        for (i in 0..6) {
            val imageModel = gambar()
            imageModel.setNames(myImageNameList[i])
            imageModel.setDess(myImageDesList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }
    
    private fun ListView.setOnClickListener(function: (Nothing, Nothing, Nothing, Nothing) -> Unit) {
        listview.adapter = ArrayAdapter(this, simple_list_item_1, myImageDesList)
        listview.setOnClickListener { parent, view, position, id ->
            Toast.makeText(
                this, "BIODATA:${myImageDesList[position]}", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
