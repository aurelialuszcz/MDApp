package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface ( modifier = Modifier.fillMaxSize()){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text("Recipe Sharing", color = Color.DarkGray, fontSize = 30.sp)
                    Button(onClick = { startActivity(createIntentRecipesWindow()) }) {
                        Text("Browse recipes", color = Color.LightGray)
                    }
                    Button(onClick = { startActivity(createIntentUploadWindow()) }) {
                        Text("Upload your recipe here!", color = Color.LightGray)
                    }
                    Button(onClick = { startActivity(createIntentAccessYtWindow())}) {
                        Text("Look for similar recipes!", color = Color.LightGray)
                    }
                }
            }
        }
    }


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
