package com.example.assignmentmain

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UploadRecipe : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                uri.value = it
                has_image.value = true
            }
            Text(current_data.value)
            Box(modifier = Modifier.fillMaxSize()) {
                /*Image(painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )*/
                // Window title
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    Text("Recipe Upload",
                        color = Color.DarkGray,
                        fontFamily = FontFamily.Serif,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp))
                }

                // Uploading image + text
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    )
                {
                    TextField(
                        value = recipe_text.value, onValueChange = { recipe_text.value = it },
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    // Image upload button
                    Button(
                        onClick = { launcher.launch("image/*") },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text("Upload", color = Color.White)
                    }
                    // Text upload button
                    Button(
                        onClick = { enterRecipe() },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text("Submit", color = Color.White)
                    }
                    Card (//elevation = CardDefaults.cardElevation(
                        //defaultElevation = 6.dp
                    //),
                        modifier = Modifier.width(250.dp)
                            .height(250.dp)
                            .padding(5.dp)
                            .wrapContentSize(Alignment.Center)
                            .background(Color.White)){
                        if (has_image.value)
                            Image(
                                bitmap = getImageBitmap(uri.value), contentDescription = null,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(200.dp)
                            )
                            Text("${entered_text.value}", color = Color.Black, textAlign = TextAlign.Center)
                    }
                }
                }
            }
        tdb = DBOpenHelper(this, "test.db", null, 1)
        sdb = tdb.writableDatabase
        }


    // Function to access image folder
    private fun getImageBitmap(image_uri: Uri?): ImageBitmap {
        if(Build.VERSION.SDK_INT >= 28) {
            val source = ImageDecoder.createSource(contentResolver, image_uri!!)
            return ImageDecoder.decodeBitmap(source).asImageBitmap()
        } else {
            return MediaStore.Images.Media.getBitmap(contentResolver, image_uri!!).asImageBitmap()
        }
    }
    // Function to show the entered text to the screen
    fun enterRecipe() {
        entered_text.value = recipe_text.value
    }

    // Database functions

    override fun onResume() {
        super.onResume()
        current_data.value = retrieveData()
    }

    override fun onStop() {
        super.onStop()
        addData()
        updateData()
    }

    private fun addData() {
        val row1: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "John")
            put("LAST_NAME", "Doe")
            put("RECIPE", "Burger")
        }

        val row2: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "Jane")
            put("LAST_NAME", "Doe")
            put("RECIPE", "Pasta")
        }

        sdb.insert("Test1", null, row1)
        sdb.insert("Test2", null, row2)
    }

    private fun updateData() {
        val row: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "Alex")
        }

        var table: String = "test"
        var where: String = "FIRST_NAME = ?"
        var where_args: Array<String> = arrayOf("Jim")
        sdb.update(table, row, where, where_args)
    }

    private fun retrieveData(): String {
        val table_name: String = "test"
        val column: Array<String> = arrayOf("ID", "FIRST_NAME", "LAST_NAME", "RECIPE")
        val where: String? = null
        val whereargs: Array<String>? = null
        val group_by: String? = null
        val having: String? = null
        val order_by: String? = null
        var c: Cursor = sdb.query(table_name, column, where, whereargs, group_by, having, order_by)
        var sb: StringBuilder = java.lang.StringBuilder()
        c.moveToFirst()
        for (i in 0 until c.count) {
            sb.append(c.getInt(0).toString())
            sb.append(" ")
            sb.append(c.getString(1).toString())
            sb.append(" ")
            sb.append(c.getString(2).toString())
            sb.append(" ")
            sb.append(c.getString(3).toString())
            sb.append(" ")
            c.moveToNext()
        }
        return sb.toString()
    }

    var has_image = mutableStateOf(false)
    var uri = mutableStateOf<Uri?>(null)
    var recipe_text = mutableStateOf("Enter your recipe here!")
    var entered_text = mutableStateOf(" ")
    private var current_data = mutableStateOf("No data present")
    private lateinit var tdb: DBOpenHelper
    private lateinit var sdb: SQLiteDatabase
}
