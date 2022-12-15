package com.diyorbek.squlitedatabaseh1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.diyorbek.squlitedatabaseh1.adapter.RvAdapter
import com.diyorbek.squlitedatabaseh1.database.MyDatabase
import com.diyorbek.squlitedatabaseh1.databinding.ActivityContactListBinding

class ContactList : AppCompatActivity() {
    private val binging by lazy { ActivityContactListBinding.inflate(layoutInflater) }
    private val myDatabase by lazy { MyDatabase(this) }
    private val rvAdapter by lazy { RvAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        supportActionBar?.hide()
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.apply {
            layoutManager = LinearLayoutManager(this@ContactList)
            adapter = rvAdapter
        }


        val stringBuilder = StringBuilder()
        myDatabase.getContacts().forEach {
            stringBuilder.append(it.toString()).append("\n")
        }
        val contact = myDatabase.getContacts()
        rvAdapter.submitList(contact)


    }
}