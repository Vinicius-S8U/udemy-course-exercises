package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseapp.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //I'VE REMOVED THE GOOGLE-SERVICES.JSON
        //IF YOU WANT IT TO WORK YOU SHOULD ADD YOUR OWN FIREBASE CONFIG :)

        //gets the reference(link to you database) from the json previously downloaded
        database = Firebase.database.reference

        //Write simple data to Firebase
//        database.child("number").setValue(191)

        //Reading data from Firebase
//        val postListener = object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val goldPrice = snapshot.value
//                binding.tvTitle.text = "The price for a gtr r35 is ${goldPrice.toString()}"
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//        }
//        database.child("price").addValueEventListener(postListener)

        //Writing custom objects to firebase
//        val leo = User("Leo","321")
//        val jack = User("Jack","123")
//        val maria = User("Maria","231")
//        val claudio = User("Claudio","213")
//        database.child("Users").setValue(listOf(leo,jack,maria,claudio))


        //Reading custom data from firebase
        val pl = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val u1 = snapshot.getValue<List<User>>()
                binding.tvTitle.text = u1.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        database.child("Users").addValueEventListener(pl)
    }
}