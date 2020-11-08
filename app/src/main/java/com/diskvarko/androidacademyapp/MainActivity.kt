package com.diskvarko.androidacademyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val imageArray = arrayListOf(R.drawable.k, R.drawable.k2, R.drawable.k3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { changeImage() }
        button_second.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    fun changeImage() {
        val rand = Random.nextInt(imageArray.size)
        imageView.setImageResource(imageArray[rand])
        viewMassage.text = this.getString(R.string.set_text)
    }


}
