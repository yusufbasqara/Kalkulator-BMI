package com.d3if3071.galerihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.d3if3071.galerihewan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 3)
        }
    }

    private fun getData(): List<Hewan> {
        return listOf(
            Hewan("Angsa", "Cygnus olor", R.drawable.angsa, "Unggas"),
            Hewan("Ayam", "Gallus gallus", R.drawable.ayam, "Unggas"),
            Hewan("Bebek", "Cairina moschata", R.drawable.bebek, "Unggas"),
            Hewan("Domba", "Ovis ammon", R.drawable.domba,"Mamalia"),
            Hewan("Kalkun", "Meleagris gallopavo", R.drawable.kalkun, "Unggas"),
            Hewan("Kambing", "Capricornis sumatrensis", R.drawable.kambing, "Mamalia"),
            Hewan("Kelinci", "Oryctolagus cuniculus", R.drawable.kelinci, "Mamalia"),
            Hewan("Kerbau", "Bubalus bubalis", R.drawable.kerbau, "Mamalia"),
            Hewan("Kuda", "Equus caballus", R.drawable.kuda, "Mamalia"),
            Hewan("Sapi", "Bos taurus", R.drawable.sapi, "Mamalia"),
        )
    }
}