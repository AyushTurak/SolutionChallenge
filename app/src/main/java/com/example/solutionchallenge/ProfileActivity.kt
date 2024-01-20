package com.example.solutionchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var email:TextView
    private lateinit var img:ImageView
    private lateinit var btn_contributor : Button
    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
    private lateinit var userDataList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        name = findViewById(R.id.pa_name)
        email = findViewById(R.id.pa_email)
        img = findViewById(R.id.ap_img)
        userDataList =  ArrayList()
        btn_contributor = findViewById(R.id.pa_btn_contributor)
        mAuth = FirebaseAuth.getInstance()
       val uid = mAuth.currentUser?.uid
        mDbRef = FirebaseDatabase.getInstance().getReference()


//        Setting name and email
 mDbRef.child("user").addValueEventListener(object  : ValueEventListener{
     override fun onDataChange(snapshot: DataSnapshot) {
         userDataList.clear()
         for(postSnapshot in snapshot.children){
             val userData = postSnapshot.getValue(User::class.java)
                 if (uid == userData?.uid){
                     name.text = userData?.name.toString()
                     email.text = userData?.email.toString()
//                 userDataList.add(userData!!)
                 }
         }
     }
     override fun onCancelled(error: DatabaseError) {
         TODO("Not yet implemented")
     }
 })

        btn_contributor.setOnClickListener {
            mDbRef.child("user").child(uid!!).setValue(User("contributor"))
        }

    }

}