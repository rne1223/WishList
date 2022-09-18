package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishes: ArrayList<Wish>
    lateinit var name: String
    lateinit var price: String
    lateinit var link: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        wishes = ArrayList()

        val adapter = WishesAdapter(wishes)
        val rvWishes = findViewById<RecyclerView>(R.id.rvWishes)
        rvWishes.adapter = adapter
        rvWishes.layoutManager = LinearLayoutManager(this)


        val etName = findViewById<EditText>(R.id.etName)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etLink = findViewById<EditText>(R.id.etLink)
        val btSubmit = findViewById<Button>(R.id.btSubmit)



        btSubmit.setOnClickListener {
            Log.e("WishList", etName.text.toString())
            Log.e("WishList", etPrice.text.toString())
            Log.e("WishList", etLink.text.toString())
            name =  etName.text.toString()
            price =  etPrice.text.toString()
            link =  etLink.text.toString()
            wishes.add(Wish(name=name, price=price, link=link))
            adapter.notifyDataSetChanged()
        }


    }
}