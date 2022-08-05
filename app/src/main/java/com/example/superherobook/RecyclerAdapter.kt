package com.example.superherobook

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(val superheronames : ArrayList<String>,val superheroinformations : ArrayList<String>, val superheroimages : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperheroVH>() {

    class SuperheroVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    //recycler_row'u bağlama
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroVH {

        //Inflater (LayoutInflater, MenuInflater..) -> xml, koda bağlanırken inflater kullanılır
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false) //itemView, oluşturduğumuz her bir recycler_row oldu
        return SuperheroVH(itemview)
    }

    //kaç tane recycle_row oluşacağı
    override fun getItemCount(): Int {
        return superheronames.size
    }

    //recycler_row'a değer atama
    override fun onBindViewHolder(holder: SuperheroVH, position: Int) {

        //her bir recycler_row'a array içindeki isim değerlerini atama
        holder.itemView.recyclerViewTextView.text = superheronames.get(position) //position, getItemCount fonksiyonunda return edilen değere kadar olan tüm indexleri 0'dan başlayarak gezer

        //recycler_row'a tıklama işlemi
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, IntroductionActivity::class.java)

            //her bir recycler_row'a tıklandığında o row'a ait intent'i (textleri), Introduction sayfasına gönderme
            intent.putExtra("heroname",superheronames.get(position))
            intent.putExtra("heroinfo",superheroinformations.get(position))

            /* verimsiz görsel tanımlama
            //her bir recycler_row'a tıklandığında o row'a ait singleton'u (görselleri), Introduction sayfasına gönderme (intent, textleri gönderebilir fakat görselleri gönderemez)
            val singleton = SingletonClass.ChosenHero
            singleton.image = superheroimages.get(position)
            */

            /* verimli görsel tanımlama */
            //her bir recycler_row'a tıklandığında o row'a ait intent'i (görselleri) , Introduction sayfasına gönderme
            intent.putExtra("heroimage", superheroimages.get(position))


            holder.itemView.context.startActivity(intent)
        }
    }
}





















