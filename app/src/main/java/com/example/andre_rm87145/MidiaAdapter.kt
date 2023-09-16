package com.example.andre_rm87145

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andre_rm87145.databinding.ItemListBinding

class MidiaAdapter : RecyclerView.Adapter<MidiaAdapter.MidiaHolder>() {

    private val listaItens: MutableList<MidiaModel> = mutableListOf()

    class MidiaHolder(val midiaList: ItemListBinding) : RecyclerView.ViewHolder(midiaList.root) {
        fun bind(item : MidiaModel) {
            midiaList.txtNome.text = item.nome
            midiaList.txtGenero.text = item.genero
            midiaList.icnFavorite.setImageResource(
                if (item.favorito) R.drawable.ic_positive else R.drawable.ic_negative
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MidiaHolder {
        return MidiaHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = listaItens.size

    override fun onBindViewHolder(holder: MidiaHolder, position: Int) {
        holder.bind(listaItens[position])
        holder.midiaList.icnFavorite.setOnClickListener {
            listaItens[position].favorito = !listaItens[position].favorito
            notifyItemChanged(position)
        }
        holder.midiaList.btnDeleteItem.setOnClickListener {
            val removed = listaItens[position]
            val removedIndex = listaItens.indexOf(removed)
            listaItens.remove(removed)
            notifyItemRemoved(removedIndex)
            notifyItemRangeChanged(removedIndex, listaItens.size)
        }
    }

    fun setItems(newList: MutableList<MidiaModel>) {
        listaItens.clear()
        listaItens.addAll(newList)
        notifyDataSetChanged()
    }

}