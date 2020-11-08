package com.diskvarko.androidacademyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diskvarko.androidacademyapp.databinding.ActivitySecondBinding
import kotlin.random.Random


class SecondActivity : AppCompatActivity() {
    val imageArraySecond = arrayListOf(R.drawable.stich1, R.drawable.stich2, R.drawable.stich3)
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { changeImage() }
        binding.buttonSecond.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun changeImage() {
        val rand = Random.nextInt(imageArraySecond.size)
        binding.imageView.setImageResource(imageArraySecond[rand])
        binding.viewMassage.text = this.getString(R.string.set_text_two)
    }
}