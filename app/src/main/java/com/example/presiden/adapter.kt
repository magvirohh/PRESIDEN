package com.example.presiden

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class adapter (private val context: Context, private val imageModelArrayList: ArrayList<gambar>) : BaseAdapter() {

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {

        return position
    }

    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return imageModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout, null, true)
            holder.tvname = convertView!!.findViewById(R.id.name) as TextView
            holder.tvdes = convertView!!.findViewById(R.id.des) as TextView
            holder.iv = convertView.findViewById(R.id.gmbr) as ImageView


            convertView.tag = holder
        } else {

            holder = convertView.tag as ViewHolder
        }

        holder.tvname!!.setText(imageModelArrayList[position].getNames())
        holder.tvdes!!.setText(imageModelArrayList[position].getDess())
        holder.iv!!.setImageResource(imageModelArrayList[position].getImage_drawables())

        return convertView
    }

    private inner class ViewHolder {

        var tvname: TextView? = null
        var tvdes: TextView? = null
        internal var iv: ImageView? = null

    }

}