package com.example.firestore_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firestore_app.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //IT'LL ONLY WORK IF YOU PUT YOUR google-services.json FROM FIREBASE
        //you should put the package name under android apps in firebase then download the json

        //Initialize Firestore
        val db = Firebase.firestore

        //Creating a collection: "Users"
//        val users_collection = db.collection("Users")

        //Creating documents
//        val jack = hashMapOf(
//            "name" to "Jack",
//            "lastName" to "Reacher",
//            "born" to "1992"
//        )
//
//        val mario = hashMapOf(
//            "name" to "Mario",
//            "lastName" to "Louis",
//            "born" to "1999"
//        )

        // Adding Documents to colection
//        users_collection.document("user1").set(jack)
//        users_collection.document("user2").set(mario)

        //get specific data from collections
//        val docRef = db.collection("Users").document("user1")
//        docRef.get().addOnSuccessListener {
//            if(it != null){
//                binding.tvTitle.text = it.data?.get("name").toString()
//            }
//        }

        //get all docs from a collection
//        var allDocuments:String = ""
//        db.collection("Users").get().addOnSuccessListener{
//            for(doc in it){
//                allDocuments += "\n${doc.data.get("name")}"
//            }
//            binding.tvTitle.text = "${allDocuments}"
//        }

        //Updating data in document
        db.collection("Users")
            .document("user1")
            .update("born",1990)


        db.collection("Users")
            .document("user2")
            .delete()
    }
}