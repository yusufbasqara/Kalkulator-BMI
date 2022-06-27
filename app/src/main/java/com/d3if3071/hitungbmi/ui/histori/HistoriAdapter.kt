package com.d3if3071.hitungbmi.ui.histori

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.d3if3071.hitungbmi.R
import com.d3if3071.hitungbmi.databinding.ItemHistoriBinding
import com.d3if3071.hitungbmi.db.BmiEntity
import com.d3if3071.hitungbmi.model.KategoriBmi
import com.d3if3071.hitungbmi.model.hitungBmi
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter  :
    ListAdapter<BmiEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<BmiEntity>() {
                override fun areItemsTheSame(
                    oldData: BmiEntity, newData: BmiEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: BmiEntity, newData: BmiEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID"))
        fun bind(item: BmiEntity) = with(binding) {
            val hasilBmi = item.hitungBmi()
            kategoriTextView.text = hasilBmi.kategori.toString().substring(0, 1)
            val colorRes = when(hasilBmi.kategori) {
                KategoriBmi.KURUS -> R.color.kurus
                KategoriBmi.IDEAL -> R.color.ideal
                else -> R.color.gemuk
            }
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(ContextCompat.getColor(root.context, colorRes))
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilBmi.bmi, hasilBmi.kategori.toString())
            val gender = root.context.getString(
                if (item.isMale) R.string.pria else R.string.wanita)
            dataTextView.text = root.context.getString(R.string.data_x,
                item.berat, item.tinggi, gender)
        }
    }


}