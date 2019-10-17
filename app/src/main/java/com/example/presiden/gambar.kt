package com.example.presiden

class gambar {var name: String? = null
    var des: String? = null
    var image_drawable: Int = 0

    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }
    fun getDess(): String {
        return des.toString()
    }

    fun setDess(des: String) {
        this.des = des
    }

    fun getImage_drawables(): Int {
        return image_drawable
    }

    fun setImage_drawables(image_drawable: Int) {
        this.image_drawable = image_drawable
    }

}