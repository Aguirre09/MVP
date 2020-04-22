package com.example.cuponera

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cuponera.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cuponera_list.view.*


class CuponAdapter (offerList: ArrayList<Offer>) :
    RecyclerView.Adapter<CuponAdapter.CuponViewHolder>() {

    private var offerList = ArrayList<Offer>()

    init {
        this.offerList = offerList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cuponera_list, parent, false)
        return CuponViewHolder(itemView)
    }

    override fun getItemCount(): Int = offerList.size

    override fun onBindViewHolder(holder: CuponViewHolder, position: Int) {
        val offers = offerList[position]
        holder.setCupon(offers)
    }

    class CuponViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var offer: Offer? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setCupon(offer: Offer) {
            this.offer = offer
            //val URL_IMAGES = "https://linkmydeals.com/"

            itemView.tv_catego.text = offer.title
            //    itemView.textView.text = offerList.voteAverage.toString()
            itemView.tv_endDate.text = offer.endDate
            if (!offer.imageUrl.isNullOrEmpty()) {
                Picasso.get().load(offer.imageUrl).into(itemView.iv_picture)
                //  Glide.with(itemView.context).load(URL_IMAGES + offerList.imageUrl).into(itemView.iv_picture)
            }

        }

        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("cupones",offer)
            itemView.context.startActivity(intent)

        }
    }
}