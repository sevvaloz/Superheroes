package com.example.superherobook

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)


        //MainActivity'den gelen intent'i alma ve bu sayfada gösterme

        val intent = intent

        // textleri tanımlama
        val name_data = intent.getStringExtra("heroname")
        textView.text = name_data

        val info_data = intent.getStringExtra("heroinfo")
        textView2.text = info_data

        /* verimsiz görsel tanımlama
        //MainActivity'den gelen singleton'u alma ve bu sayfada gösterme
        val hero = SingletonClass.ChosenHero //bitmapleri, singleton class olarak tanımladığımız için her yerden aynı nesneye erişiriz
        val image = hero.image
        imageView.setImageBitmap(image)
        */

        // verimli görsel tanımlama
        val image_data = intent.getIntExtra("heroimage", 0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, image_data)
        imageView.setImageBitmap(bitmap)
    }
}