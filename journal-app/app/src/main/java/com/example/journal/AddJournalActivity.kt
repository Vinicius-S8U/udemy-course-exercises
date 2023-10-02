package com.example.journal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.journal.databinding.ActivityAddJournalBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.Date

class AddJournalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddJournalBinding

    //Credentials
    var currentUserId: String = ""
    var currentUserName: String = ""

    //Firebase
    lateinit var auth: FirebaseAuth
    lateinit var user: FirebaseUser

    //Firestore
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var storageReference: StorageReference
    var collectionReference: CollectionReference = db.collection("Journal")
    private lateinit var imageUri: Uri


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                imageUri = data.data!!
                binding.postIv.setImageURI(imageUri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddJournalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storageReference = FirebaseStorage.getInstance().reference
        auth = Firebase.auth

        with(binding) {
            postProgressBar.visibility = View.INVISIBLE
            if (JournalUser.instance != null) {
                currentUserId = auth.currentUser?.uid.toString()
                currentUserName  = auth.currentUser?.displayName.toString()

                postUsernameTv.text = currentUserName
            }

            postJournalSaveBtn.setOnClickListener {
                saveJournalData()
            }

            postCameraIv.setOnClickListener {
                var i = Intent(Intent.ACTION_GET_CONTENT)
                i.setType("image/*")
                startActivityForResult(i, 1)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        user = auth.currentUser!!
    }

    override fun onStop() {
        super.onStop()
        if (auth != null) {

        }
    }


    fun saveJournalData() = with(binding) {
        val title = postTitleEt.text.toString().trim()
        val thoughts = postDescriptionEt.text.toString().trim()

        postProgressBar.visibility = View.VISIBLE
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(thoughts) && imageUri != null) {
            val filePath = storageReference.child("journal_images")
                .child("my_images_" + Math.random())

            filePath.putFile(imageUri).addOnSuccessListener {
                filePath.downloadUrl.addOnSuccessListener {
                    val imageUri: String = it.toString()
                    val timeStamp = Timestamp(Date())

                    val journal = Journal(
                        userId = currentUserId,
                        username = currentUserName,
                        title = title,
                        thoughts = thoughts,
                        imageUrl = imageUri,
                        timeAdded = timeStamp
                    )
                    collectionReference.add(journal).addOnSuccessListener {
                        postProgressBar.visibility = View.INVISIBLE
                        var intent =
                            Intent(this@AddJournalActivity, JournalListActivity::class.java)
                        startActivity(intent)
                    }
                }
            }.addOnFailureListener {
                binding.postProgressBar.visibility = View.INVISIBLE
            }
        } else {
            binding.postProgressBar.visibility = View.INVISIBLE
        }
    }

}