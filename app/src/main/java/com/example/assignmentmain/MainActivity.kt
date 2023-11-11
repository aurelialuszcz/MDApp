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
                    Button(onClick = { startActivity(createIntentFourthWindow()) }) {
                        Text("Browse recipes", color = Color.LightGray)
                    }
                    Button(onClick = { startActivity(createIntentSecondWindow()) }) {
                        Text("Upload your recipe here!", color = Color.LightGray)
                    }
                    Button(onClick = { startActivity(createIntentThirdWindow())}) {
                        Text("Look for similar recipes!", color = Color.LightGray)
                    }
                }
            }
        }
    }


    private fun createIntentSecondWindow(): Intent {
        var intent: Intent = Intent(this, SecondWindow::class.java)

        return intent
    }

    private fun createIntentThirdWindow(): Intent {
        var intent: Intent = Intent(this, ThirdWindow::class.java)

        return intent
    }

    private fun createIntentFourthWindow(): Intent {
        var intent: Intent = Intent(this, FourthWindow::class.java)

        return intent
    }
}
