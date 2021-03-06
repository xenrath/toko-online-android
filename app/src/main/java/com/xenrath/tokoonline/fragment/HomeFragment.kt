package com.xenrath.tokoonline.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.xenrath.tokoonline.R
import com.xenrath.tokoonline.adapter.AdapterProduk
import com.xenrath.tokoonline.adapter.AdapterSlider
import com.xenrath.tokoonline.model.Produk

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvProduk: RecyclerView
    lateinit var rvTerlaris: RecyclerView
    lateinit var rvRekomendasi: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvTerlaris = view.findViewById(R.id.rv_terlaris)
        rvRekomendasi = view.findViewById(R.id.rv_rekomendasi)

        val arraySlider = ArrayList<Int>()
        arraySlider.add(R.drawable.avokad)
        arraySlider.add(R.drawable.cherry)
        arraySlider.add(R.drawable.strawberry)

        val adapterSlider = AdapterSlider(arraySlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrayProduk)
        rvProduk.layoutManager = layoutManager

        rvTerlaris.adapter = AdapterProduk(arrayTerlaris)
        rvTerlaris.layoutManager = layoutManager1

        rvRekomendasi.adapter = AdapterProduk(arrayRekomendasi)
        rvRekomendasi.layoutManager = layoutManager2

        return view
    }

    val arrayProduk: ArrayList<Produk>get(){
        val array = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "Buah 1"
        p1.harga = "Rp. 1.500.000"
        p1.gambar = R.drawable.buah1

        val p2 = Produk()
        p2.nama = "Buah 2"
        p2.harga = "Rp. 1.200.000"
        p2.gambar = R.drawable.buah2

        val p3 = Produk()
        p3.nama = "Buah 3"
        p3.harga = "Rp. 1.000.000"
        p3.gambar = R.drawable.buah3

        array.add(p1)
        array.add(p2)
        array.add(p3)

        return array
    }

    val arrayTerlaris: ArrayList<Produk>get(){
        val array = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "Buah 1"
        p1.harga = "Rp. 1.500.000"
        p1.gambar = R.drawable.buah1

        val p2 = Produk()
        p2.nama = "Buah 2"
        p2.harga = "Rp. 1.200.000"
        p2.gambar = R.drawable.buah2

        val p3 = Produk()
        p3.nama = "Buah 3"
        p3.harga = "Rp. 1.000.000"
        p3.gambar = R.drawable.buah3

        array.add(p1)
        array.add(p2)
        array.add(p3)

        return array
    }

    val arrayRekomendasi: ArrayList<Produk>get(){
        val array = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "Buah 1"
        p1.harga = "Rp. 1.500.000"
        p1.gambar = R.drawable.buah1

        val p2 = Produk()
        p2.nama = "Buah 2"
        p2.harga = "Rp. 1.200.000"
        p2.gambar = R.drawable.buah2

        val p3 = Produk()
        p3.nama = "Buah 3"
        p3.harga = "Rp. 1.000.000"
        p3.gambar = R.drawable.buah3

        array.add(p1)
        array.add(p2)
        array.add(p3)

        return array
    }
}