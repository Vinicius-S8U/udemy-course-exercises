package com.example.journal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.journal.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener {
            LogInWEmailPassword(
                binding.etEmail.text.toString().trim(),
                binding.etPassword.text.toString().trim()
            )
        }
    }

    private fun LogInWEmailPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {task ->
            if(task.isSuccessful) {

                var journal = JournalUser.instance!!
                journal.userId = auth.currentUser?.uid
                journal.username = auth.currentUser?.displayName

                goToJournalList()
            }else{
                Toast.makeText(this,"Authentication failed",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            goToJournalList()
        }
    }

    private fun goToJournalList() {
        var intent = Intent(this,JournalListActivity::class.java)
        startActivity(intent)
    }
}