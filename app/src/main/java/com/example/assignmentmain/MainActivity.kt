package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text("Welcome to the main window")
                Button(onClick = { startActivity(createIntentSecondWindow()) }) {
                    Text("Next window")
                }
            }
        }
    }


    private fun createIntentSecondWindow(): Intent {
        var intent: Intent = Intent(this, SecondWindow::class.java)

        return intent
    }

    private fun createIntentThirddWindow(): Intent {
        var intent: Intent = Intent(this, ThirdWindow::class.java)

        return intent
    }
}
