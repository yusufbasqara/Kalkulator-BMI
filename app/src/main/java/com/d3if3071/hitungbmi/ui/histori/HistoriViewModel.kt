package com.d3if3071.hitungbmi.ui.histori

import androidx.lifecycle.ViewModel
import com.d3if3071.hitungbmi.db.BmiDao

class HistoriViewModel(db: BmiDao) : ViewModel() {
    val data = db.getLastBmi()
}