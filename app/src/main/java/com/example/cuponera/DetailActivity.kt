package com.example.cuponera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cuponera.model.Cupones
import com.example.cuponera.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cuponera_list.view.*
import kotlinx.android.synthetic.main.cuponera_list.view.tv_catego
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cupo = intent?.getSerializableExtra("cupones") as Offer
        updateUI(cupo)
    }

    private fun updateUI(cupo: Offer){

        tv_catego.text = cupo.title
        //    itemView.textView.text = offerList.voteAverage.toString()
        tv_endDate.text = cupo.endDate
        if (!cupo.imageUrl.isNullOrEmpty()) {
            Picasso.get().load(cupo.imageUrl).into(iv_picture)
            //  Glide.with(itemView.context).load(URL_IMAGES + offerList.imageUrl).into(itemView.iv_picture)
        }
    }







}
