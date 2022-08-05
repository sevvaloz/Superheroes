package com.example.superherobook

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Veri Hazırlığı

        var superheroNames = ArrayList<String>()
        superheroNames.add("Superman")
        superheroNames.add("Batman")
        superheroNames.add("Spiderman")
        superheroNames.add("Ironman")
        superheroNames.add("Aquman")

        var superheroInformations = ArrayList<String>()
        superheroInformations.add("Superman was born on the fictional planet Krypton and was named Kal-El. As a baby, his parents sent him to Earth in a small spaceship moments before Krypton was destroyed in a natural cataclysm. His ship landed in the American countryside, near the fictional town of Smallville. He was found and adopted by farmers Jonathan and Martha Kent, who named him Clark Kent. Clark developed various superhuman abilities, such as incredible strength and impervious skin. His adoptive parents advised him to use his abilities for the benefit of humanity, and he decided to fight crime. To protect his personal life, he changes into a colorful costume and uses the alias \"Superman\" when fighting crime. Clark resides in the fictional American city of Metropolis, where he works as a journalist for the Daily Planet.")
        superheroInformations.add("Batman was originally introduced as a ruthless vigilante who frequently killed or maimed criminals, but evolved into a character with a stringent moral code and strong sense of justice. Unlike most superheroes, Batman does not possess any superpowers, instead relying on his intellect, fighting skills, and wealth. The 1960s Batman television series used a camp aesthetic, which continued to be associated with the character for years after the show ended. Various creators worked to return the character to his darker roots in the 1970s and 1980s, culminating with the 1986 miniseries The Dark Knight Returns by Frank Miller.")
        superheroInformations.add("When Spider-Man first appeared in the early 1960s, teenagers in superhero comic books were usually relegated to the role of sidekick to the protagonist. The Spider-Man series broke ground by featuring Peter Parker, a high school student from Queens, New York, as Spider-Man's secret identity, whose \"self-obsessions with rejection, inadequacy, and loneliness\" were issues to which young readers could relate. While Spider-Man had all the makings of a sidekick, unlike previous teen heroes such as Bucky and Robin, Spider-Man had no superhero mentor like Captain America and Batman; he thus had to learn for himself that \"with great power there must also come great responsibility\"")
        superheroInformations.add("A wealthy American business magnate, playboy, philanthropist, inventor and ingenious scientist, Anthony Edward Stark suffers a severe chest injury during a kidnapping. When his captors attempt to force him to build a weapon of mass destruction, he instead creates a mechanized suit of armor to save his life and escape captivity. Later, Stark develops his suit, adding weapons and other technological devices he designed through his company, Stark Industries. He uses the suit and successive versions to protect the world as Iron Man. Although at first concealing his true identity, Stark eventually publicly reveals himself to be Iron Man.  Initially, Iron Man was a vehicle for Stan Lee to explore Cold War themes, particularly the role of American technology and industry in the fight against communism. Subsequent re-imaginings of Iron Man have transitioned from Cold War motifs to contemporary matters of the time.")
        superheroInformations.add("Aquaman is a DC Comics character. His body is very durable. He was fired because he was the only blonde in Atlantis. He can communicate with and dominate aquatic creatures. It moves very quickly under water. The spear is one of the most powerful weapons. He is one of the Justice League characters.")

        //Verimsiz Veri Hazırlığı (Bitmap Oluşturma)
        /*
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.spiderman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)
        val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.aquaman)

        var superheroBitmaps = ArrayList<Bitmap>()
        superheroBitmaps.add(supermanBitmap)
        superheroBitmaps.add(batmanBitmap)
        superheroBitmaps.add(spidermanBitmap)
        superheroBitmaps.add(ironmanBitmap)
        superheroBitmaps.add(aquamanBitmap)
        */

        //Verimli Tanımlamalar (Görselleri nasıl daha verimli halde gönderebiliriz)

        val supermanId = R.drawable.superman //bu sefer bitmap değil, int tipinde id göndericez
        val batmanId = R.drawable.batman
        val spidermanId = R.drawable.spiderman
        val ironmanId = R.drawable.ironman
        val aquamanId = R.drawable.aquaman

        var superheroIds = ArrayList<Int>()
        superheroIds.add(supermanId)
        superheroIds.add(batmanId)
        superheroIds.add(spidermanId)
        superheroIds.add(ironmanId)
        superheroIds.add(aquamanId)


        //Layout Manager

        val layoutManager = LinearLayoutManager(this) //recyclerView'da oluşturduğumuz şeyleri alt alta koymak için linearlayout kullanırız
        recyclerView.layoutManager = layoutManager // buradaki recylerView, görünümdeki elemanın id'sidir

        //Adapter

        val adapter = RecyclerAdapter(superheroNames,superheroInformations,superheroIds)
        recyclerView.adapter = adapter

    }
}