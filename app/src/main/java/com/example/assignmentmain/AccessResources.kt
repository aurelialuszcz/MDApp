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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AccessResources : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val youtubeIcon = painterResource(id = R.drawable.youtube)
            val googleIcon = painterResource(id = R.drawable.google)
            Surface(modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    // Window title
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            "Search for more inspiration",
                            color = Color.White,
                            fontFamily = FontFamily.Serif,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    // Text to search on youtube
                    TextField(value = recipe_lookup.value, onValueChange = {recipe_lookup.value = it},
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color = Color.Gray)
                            .fillMaxWidth())
                    Column {
                        Row {
                            Image(
                                painter = youtubeIcon,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            // Button to access youtube
                            Button(onClick = {
                                // Passing text field value for youtube search
                                val searchIntent = Intent(Intent.ACTION_SEARCH)
                                searchIntent.setPackage("com.google.android.youtube")
                                searchIntent.putExtra(SearchManager.QUERY, recipe_lookup.value)
                                try {
                                    startActivity(searchIntent)
                                } catch (e: ActivityNotFoundException) {
                                    e.printStackTrace()
                                }
                            }
                            , modifier = Modifier.padding(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray,
                                    contentColor = Color.White
                                ))
                            {
                                Text("Go to Youtube")
                            }
                        }
                        Row {
                            Image(
                                painter = googleIcon,
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Button(onClick = {
                                // Passing text field value for google search
                                val searchIntent2 = Intent(Intent.ACTION_WEB_SEARCH)
                                searchIntent2.putExtra(SearchManager.QUERY, recipe_lookup.value)
                                try {
                                    startActivity(searchIntent2)
                                } catch (e: ActivityNotFoundException) {
                                    e.printStackTrace()
                                }
                            }
                                , modifier = Modifier.padding(5.dp)
                                ,colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray,
                                    contentColor = Color.White
                                )) {
                                Text("Go to Google")
                            }
                        }
                    }
                }
            }
            }
        }
    var recipe_lookup = mutableStateOf("Enter your search here!")
    }

