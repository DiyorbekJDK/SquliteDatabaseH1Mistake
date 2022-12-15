package com.diyorbek.squlitedatabaseh1.database

import com.diyorbek.squlitedatabaseh1.model.Contact

interface DatabaseService {
    fun saveContact(contact: Contact)
    fun getContacts(): List<Contact>
}