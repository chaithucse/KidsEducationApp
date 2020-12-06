package com.neha.edu

import android.annotation.SuppressLint
import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.google.android.material.textview.MaterialTextView
import java.util.*

class GridAdapter(var context: Context, var imagesList: List<Int>, var imageLabels: List<String>) : BaseAdapter(), TextToSpeech.OnInitListener {
    private var mTtsEngine: TextToSpeech? = null

    init {
        mTtsEngine = TextToSpeech(context, this)
    }

    override fun getCount(): Int {
        return imagesList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layView = inflater.inflate(R.layout.grid_items, null)
        val imageView = layView.findViewById<ImageView>(R.id.image_view)
        /* val bmp = BitmapFactory.decodeFile(imagesList.get(pos).toString())
         imageView.setImageBitmap(bmp)*/
        imageView.setImageResource(imagesList.get(pos))
        layView.findViewById<MaterialTextView>(R.id.image_lable).text = imageLabels.get(pos)

        imageView.setOnClickListener {
            mTtsEngine!!.speak(imageLabels.get(pos), TextToSpeech.QUEUE_FLUSH, null)

        }
        return layView
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            mTtsEngine!!.language = Locale.US
        }
    }
}