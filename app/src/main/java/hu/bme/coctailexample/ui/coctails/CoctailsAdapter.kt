package hu.bme.coctailexample.ui.coctails

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import hu.bme.coctailexample.R
import hu.bme.coctailexample.model.Item
import kotlinx.android.synthetic.main.card_coctail.view.*

class CoctailsAdapter constructor(
    private val context: Context,
    private var artists: List<Item>) : RecyclerView.Adapter<CoctailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_coctail, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
/*
        artist.images?.let {
            val images = artist.images!!
            if (images.isNotEmpty()) {
                Glide.with(context).load(images[0].url).into(holder.ivImage)
            }
        }

        holder.tvName.text = artist.name
        holder.tvPopularity.text = artist.popularity!!.toString() */
    }

    override fun getItemCount() = artists.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var tvName: TextView = view.tvName
        var tvPopularity: TextView = view.tvPopularity
    }
}
