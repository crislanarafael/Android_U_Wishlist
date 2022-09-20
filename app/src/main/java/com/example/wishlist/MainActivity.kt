package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var items: ArrayList<WishList> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val submitBtn = findViewById<Button>(R.id.submitButton)
        val itemName = findViewById<EditText>(R.id.itemName)
        val itemDescription = findViewById<EditText>(R.id.itemDescription)
        val itemPrice = findViewById<EditText>(R.id.itemPrice)


        //wishListRV.layoutManager = LinearLayoutManager(this)

        val wishListRV = findViewById<RecyclerView>(R.id.wishlistRV)

        val adapter = WishlistAdapter(items)

        wishListRV.adapter = adapter
        wishListRV.layoutManager = LinearLayoutManager(this)

        submitBtn.setOnClickListener{
            var name = itemName.text.toString()
            var price = itemPrice.text.toString()
            var description = itemDescription.text.toString()
            items.add(WishList(name, price, description))
            adapter.notifyDataSetChanged()

        }







    }
}