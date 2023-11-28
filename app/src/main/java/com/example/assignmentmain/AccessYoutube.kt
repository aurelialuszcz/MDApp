package com.example.assignmentmain

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class AccessYoutube : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val youtubeIcon = painterResource(id = R.drawable.youtube)
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                   // Youtube image
                    Image(
                        painter = youtubeIcon,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    // Text to search on youtube
                    TextField(value = recipe_lookup.value, onValueChange = {recipe_lookup.value = it},
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color = Color.Gray))
                    // Button to access youtube
                    Button(onClick = {
                        /*Intent(Intent.ACTION_SEARCH).also {
                            it.`package` = "com.google.android.youtube"
                            intent.putExtra(SearchManager.QUERY, recipe_lookup.value)
                            try {
                                startActivity(it)
                            } catch (e: ActivityNotFoundException) {
                                e.printStackTrace()
                            }*/
                        val searchIntent = Intent(Intent.ACTION_SEARCH)
                        searchIntent.setPackage("com.google.android.youtube")
                        searchIntent.putExtra(SearchManager.QUERY, recipe_lookup.value)
                        try {
                            startActivity(searchIntent)
                        } catch (e: ActivityNotFoundException) {
                            e.printStackTrace()
                        }
                        }
                    )
                    {
                        Text("Go to Youtube")
                    }
                }
            }
            }
        }

    var recipe_lookup = mutableStateOf("Enter your search here!")
    }

