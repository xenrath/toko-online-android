package com.xenrath.tokoonline.model

import java.io.Serializable

class Produk : Serializable {
    lateinit var nama: String
    lateinit var harga: String
    var gambar: Int = 0
}