package com.uce.moviles.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.uce.moviles.R
import com.uce.moviles.data.local.entities.Users
import com.uce.moviles.data.network.entities.jikan.juego.DataJuegosItem
import com.uce.moviles.data.network.entities.jikan.top.Data
import com.uce.moviles.data.network.entities.jikan.top.TopAnime
import com.uce.moviles.databinding.AnimeItemsBinding
import com.uce.moviles.databinding.UsersItemsBinding


class AnimeAdapter(private val listUsers: List<DataJuegosItem>) : RecyclerView.Adapter<AnimeAdapter.AnimeVH>() {

    class AnimeVH(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: AnimeItemsBinding = AnimeItemsBinding.bind(view)

        fun render(item: DataJuegosItem) {

            binding.txtID.text = item.title
            binding.txtNAME.text = item.developer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeVH {
        val inflater = LayoutInflater.from(parent.context)
        return AnimeVH(inflater.inflate(R.layout.anime_items, parent, false))
    }

    override fun getItemCount(): Int = listUsers.size //Numero de datos de la lista

    override fun onBindViewHolder(holder: AnimeVH, position: Int) { // Bind = hace match el elemento con indice[]
        holder.render(listUsers[position])
    }
}