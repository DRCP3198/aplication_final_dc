package com.uce.moviles.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.uce.moviles.R
import com.uce.moviles.data.network.entities.jikan.juego.DataJuegosItem
import com.uce.moviles.databinding.JuegosItemsBinding

class JuegoAdapter(private val listUsers: List<DataJuegosItem>) :
    RecyclerView.Adapter<JuegoAdapter.AnimeVH>() {

    class AnimeVH(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: JuegosItemsBinding = JuegosItemsBinding.bind(view)

        fun render(item: DataJuegosItem) {

            binding.avatarImg.load("https://img.freepik.com/vector-gratis/consola-juegos-letras-letrero-neon-fondo-ladrillo_1262-11854.jpg?w=740&t=st=1708762114~exp=1708762714~hmac=86e6657b0ed274905c72b26c8cbb0562e9a89d65d3adf1a1a51b552aeaf2dae3")
            binding.txtID.text = item.id.toString()
            binding.txtTitle.text = item.title
            binding.txtDeveloper.text = item.developer
            binding.txtPlatform.text = item.platform
            binding.txtshortDescription.text = item.short_description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeVH {
        val inflater = LayoutInflater.from(parent.context)
        return AnimeVH(inflater.inflate(R.layout.juegos_items, parent, false))
    }

    override fun getItemCount(): Int = listUsers.size //Numero de datos de la lista

    override fun onBindViewHolder(
        holder: AnimeVH,
        position: Int
    ) { // Bind = hace match el elemento con indice[]
        holder.render(listUsers[position])
    }
}