package com.example.journal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.journal.databinding.ActivityJournalListBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference

class JournalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJournalListBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var user: FirebaseUser
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var storageReference: StorageReference
    lateinit var journalList: MutableList<Journal>
    lateinit var adapter: JournalRecyclerAdapter
    var collectionReference: CollectionReference = db.collection("Journal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJournalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = Firebase.auth
        user = firebaseAuth.currentUser!!

        binding.journalRv.setHasFixedSize(true)
        binding.journalRv.layoutManager = LinearLayoutManager(this)
        journalList = arrayListOf()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> if (user != null && firebaseAuth != null) {
                val intent = Intent(this, AddJournalActivity::class.java)
                startActivity(intent)
            }

            R.id.action_signout -> if (user != null && firebaseAuth != null) {
                firebaseAuth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        collectionReference.whereEqualTo("userId", user.uid).get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    binding.listNoPosts.isVisible = false
                    for(document in it){
                        document.data.apply {
                            var journal = Journal(
                                userId = get("userId").toString(),
                                username = get("username").toString(),
                                title = get("title").toString(),
                                thoughts = get("thoughts").toString(),
                                imageUrl = get("imageUrl").toString(),
                                timeAdded = get("timeAdded") as Timestamp,
                            )

                            journalList.add(journal)
                        }
                    }

                    adapter = JournalRecyclerAdapter(journalList)
                    binding.journalRv.adapter = adapter
                    adapter.notifyDataSetChanged()
                } else {
                    binding.listNoPosts.isVisible = true
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
    }
}