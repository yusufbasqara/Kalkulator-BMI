package com.d3if3071.hitungbmi.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3071.hitungbmi.db.BmiDao
import com.d3if3071.hitungbmi.db.BmiEntity
import com.d3if3071.hitungbmi.model.HasilBmi
import com.d3if3071.hitungbmi.model.KategoriBmi
import com.d3if3071.hitungbmi.model.hitungBmi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: BmiDao) : ViewModel() {
    private val hasilBmi = MutableLiveData<HasilBmi?>()
    private val navigasi = MutableLiveData<KategoriBmi?>()


    fun hitungBmi(berat: Float, tinggi: Float, isMale: Boolean) {
        val dataBmi = BmiEntity(
            berat = berat,
            tinggi = tinggi,
            isMale = isMale
        )
        hasilBmi.value = dataBmi.hitungBmi()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               db.insert(dataBmi)
            }
        }
    }

    fun getHasilBmi(): LiveData<HasilBmi?> = hasilBmi

    fun mulaiNavigasi() {
        navigasi.value = hasilBmi.value?.kategori
    }
    fun selesaiNavigasi() {
        navigasi.value = null
    }
    fun getNavigasi() : LiveData<KategoriBmi?> = navigasi
}
