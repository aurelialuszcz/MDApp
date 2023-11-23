package com.example.assignmentmain

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class AccessYoutube : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFBDF0D1)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    // Button to access youtube
                    Button(onClick = {
                        Intent(Intent.ACTION_MAIN).also {
                            it.`package` = "com.google.android.youtube"
                            try {
                                startActivity(it)
                            } catch (e: ActivityNotFoundException) {
                                e.printStackTrace()
                            }
                        }
                    })
                    {
                        Text("Go to Youtube")
                    }
                }
            }
            }
        }
    }

