  package com.xenrath.tokoonline.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.xenrath.tokoonline.R
import com.xenrath.tokoonline.activity.DetailProductActivity
import com.xenrath.tokoonline.helper.Helper
import com.xenrath.tokoonline.model.Product
import java.util.*
import kotlin.collections.ArrayList

  class AdapterProduk(var activity: Context, var data: ArrayList<Product>) : RecyclerView.Adapter<AdapterProduk.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name
        holder.tvHarga.text = Helper().changeCurrency(data[position].price)
//        holder.imgProduk.setImageResource(data[position].image)
        val image = "http://192.168.1.9/tokoonline/public/storage/product/" + data[position].image
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_placeholder)
                .into(holder.imgProduk)

        holder.layout.setOnClickListener{
            val intent = Intent(activity, DetailProductActivity::class.java)
            val str = Gson().toJson(data[position], Product::class.java)
            intent.putExtra("extra", str)

            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}