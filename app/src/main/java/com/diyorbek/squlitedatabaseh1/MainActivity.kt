package com.diyorbek.squlitedatabaseh1

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.pink)

        val btn: MaterialButton = findViewById(R.id.contactList)
        val btn2: MaterialButton = findViewById(R.id.createContact)
        btn.setOnClickListener {
            val intent = Intent(this, ContactList::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, SaveContactActivity::class.java)
            startActivity(intent)
        }

    }
}