package com.diyorbek.squlitedatabaseh1.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.diyorbek.squlitedatabaseh1.model.Contact
import com.diyorbek.squlitedatabaseh1.util.Constantas
import com.diyorbek.squlitedatabaseh1.util.Constantas.ID
import com.diyorbek.squlitedatabaseh1.util.Constantas.NAMEANDLASTNAME
import com.diyorbek.squlitedatabaseh1.util.Constantas.NUMBER
import com.diyorbek.squlitedatabaseh1.util.Constantas.TABLE_NAME

class MyDatabase(context: Context): SQLiteOpenHelper(context,Constantas.DB_NAME,null,1),DatabaseService {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,$NAMEANDLASTNAME TEXT NOT NULL, $NUMBER TEXT NOT NULL)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    override fun saveContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAMEANDLASTNAME,contact.nameAndLastName)
        contentValues.put(NUMBER,contact.number)
        database.insert(TABLE_NAME,null,contentValues)
    }

    override fun getContacts(): List<Contact> {
        val database = this.readableDatabase
        val contactList = mutableListOf<Contact>()
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val contact = Contact(cursor.getString(0),cursor.getString(1))
                contactList.add(contact)
            } while (cursor.moveToNext())
        }
        return contactList
    }
}