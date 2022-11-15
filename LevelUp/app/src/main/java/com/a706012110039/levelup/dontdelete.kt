package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import model.files


class dontdelete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dontdelete)
        var intent = intent
        var uirr = intent.getStringExtra("data")

        geturiData(Uri.parse(uirr))

    }



    fun geturiData(uri: Uri) {

        lateinit var temp: String
        uri.userInfo?.let { Log.d("what", it) }

        Log.d("contenet resolver", contentResolver.toString())


        val cursor: Cursor? = contentResolver?.query(
            uri, null, null, null, null, null)
        cursor?.use { cursor ->
            Log.d("ascasdfasd", "sidbna asdasfdafasd")

            /*
             * Get the column indexes of the data in the Cursor,
             * move to the first row in the Cursor, get the data,
             * and display it.
             */
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            cursor.moveToFirst()
            Log.d("name", cursor.getString(nameIndex))

            temp = cursor.getString(nameIndex)
        }

        GlobalVar.tempDATAFILE = temp
        GlobalVar.projects[GlobalVar.projects.size -1].files.add(files(temp,"",""))
        finish()
    }
}