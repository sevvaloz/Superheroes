package com.example.superherobook

import android.graphics.Bitmap

class SingletonClass {
    //Singleton, nereden çağırırsak çağıralım hep aynı nesneyi döndürür
    companion object ChosenHero{
        var image : Bitmap? = null
    }
}