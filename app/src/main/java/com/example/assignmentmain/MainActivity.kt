package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFBDF0D1)){
                Column (
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    // Welcome title
                    Text(
                        "Recipe Sharing",
                        color = Color.DarkGray,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
                Column (
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    // First activity button
                    Button(onClick = { startActivity(createIntentRecipesWindow()) }) {
                        Text("Browse recipes", color = Color.LightGray)
                    }
                    // Second activity button
                    Button(onClick = { startActivity(createIntentUploadWindow()) }) {
                        Text("Upload your recipe here!", color = Color.LightGray)
                    }
                    // Third activity button
                    Button(onClick = { startActivity(createIntentAccessYtWindow())}) {
                        Text("Look for similar recipes!", color = Color.LightGray)
                    }
                }
            }
        }
    }

    // Creating intent for each activity
    private fun createIntentUploadWindow(): Intent {
        var intent: Intent = Intent(this, UploadRecipe::class.java)

        return intent
    }

    private fun createIntentAccessYtWindow(): Intent {
        var intent: Intent = Intent(this, AccessYoutube::class.java)

        return intent
    }

    private fun createIntentRecipesWindow(): Intent {
        var intent: Intent = Intent(this, ExistingRecipes::class.java)

        return intent
    }
}
