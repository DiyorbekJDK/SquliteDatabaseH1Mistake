package com.diyorbek.squlitedatabaseh1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diyorbek.squlitedatabaseh1.database.MyDatabase
import com.diyorbek.squlitedatabaseh1.databinding.ActivitySaveContactBinding
import com.diyorbek.squlitedatabaseh1.model.Contact

class SaveContactActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySaveContactBinding.inflate(layoutInflater) }
    private val myDatabase by lazy { MyDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_contact)
        supportActionBar?.hide()

        binding.addBtn.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val number = binding.editNumber.text.toString().trim()
            //if (name.isNotEmpty() && number.isNotEmpty()){
            val contact = Contact(name, number)
            myDatabase.saveContact(contact)
            binding.editName.text?.clear()
            binding.editNumber.text?.clear()
            Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
            val stringBuilder = StringBuilder()
            myDatabase.getContacts().forEach {
                stringBuilder.append(it.toString()).append("\n")
            }
            //}

        }
    }
}