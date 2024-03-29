package com.d3if3071.assesment1_kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.d3if3071.assesment1_kalkulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungLuas() }
        binding.button2.setOnClickListener { reset() }

    }

    private fun reset() {
        binding.editTextNumber.text.clear()
        binding.editTextNumber2.text.clear()
        binding.editTextNumber3.text.clear()
        binding.radioGroup.clearCheck()
        binding.hasilLuas.text = getString(R.string.luas_bangun)

    }

    private fun hitungLuas() {
        val panjang = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_SHORT).show()
        }


        val lebar = binding.editTextNumber2.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_SHORT).show()
        }

        val tinggi = binding.editTextNumber3.text.toString()


        val selectedId = binding.radioGroup.checkedRadioButtonId

        if (selectedId == 2131230956 || selectedId == 2131230807) {
            if (TextUtils.isEmpty(tinggi)) {
                Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_SHORT).show()
            }
            if (!TextUtils.isEmpty(panjang) && !TextUtils.isEmpty(lebar) && !TextUtils.isEmpty(
                    tinggi
                )
            ) {
                val hasilBangunRuang =
                    (panjang.toDouble() * lebar.toDouble() * tinggi.toDouble())
                binding.hasilLuas.text = hasilBangunRuang.toString()
            }
        } else {
            val hasilBangunDatar = panjang.toDouble() * lebar.toDouble()
            binding.hasilLuas.text = hasilBangunDatar.toString()
        }

        Log.d("check id", selectedId.toString())
    }
}