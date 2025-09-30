package com.example.lab_week06_104642

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week06_104642.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list untuk menyimpan data
    private val cats = mutableListOf<CatModel>()

    // fungsi untuk set data list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // memberitahu adapter kalau ada perubahan data
        notifyDataSetChanged()
    }

    // membuat view holder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    // jumlah item dalam list
    override fun getItemCount(): Int = cats.size

    // binding data ke view holder
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    // deklarasi interface listener
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
