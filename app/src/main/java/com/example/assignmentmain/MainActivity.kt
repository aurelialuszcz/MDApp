package com.example.assignmentmain

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()){
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    // Welcome title
                    Text(
                        "Recipe Sharing",
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
                // Column to arrange buttons
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {

                        // First activity button
                        Button(onClick = { startActivity(createIntentRecipesWindow()) }
                        ,colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        ),
                            modifier = Modifier.padding(10.dp)) {
                            Text("Browse", modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp))
                        }
                        // Second activity button
                        Button(onClick = { startActivity(createIntentUploadWindow()) }
                            ,colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        ),
                            modifier = Modifier.padding(10.dp)) {
                            Text("Upload", modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp))
                        }
                        // Third activity button
                        Button(onClick = { startActivity(createIntentAccessYtWindow()) }
                            ,colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        ),
                            modifier = Modifier.padding(10.dp)) {
                            Text("Search", modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp))
                        }
                    registerSensorListeners()
                    }
            }
        }
    }

    // Creating intent for each activity
    private fun createIntentUploadWindow(): Intent {
        val intent = Intent(this, UploadRecipe::class.java)

        return intent
    }

    private fun createIntentAccessYtWindow(): Intent {
        val intent = Intent(this, AccessResources::class.java)

        return intent
    }

    private fun createIntentRecipesWindow(): Intent {
        val intent = Intent(this, ExistingRecipes::class.java)

        return intent
    }
    private fun registerSensorListeners() {

        var sm: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        if(sm.getDefaultSensor(Sensor.TYPE_LIGHT) != null)
            sm.registerListener(light_listener, sm.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI)
    }

    private var light_listener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            if (event!!.values[0] > 60) {
                Toast.makeText(applicationContext, "Too bright! Adjust your brightness levels.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, null, Toast.LENGTH_SHORT).cancel()
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

        }
    }
}
