package com.example.assignmentmain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ExistingRecipes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(),
                color = Color.LightGray) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    burger()
                    pizza()
                }
            }
        }
    }

    @Preview
    @Composable
    fun burger() {
        val burgerImg = painterResource(id = R.drawable.burger)
        Box (modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp)
            .padding(20.dp)
            .border(1.dp, Color.Black)) {
            Column {
                // Recipe title
                Text("Burger", color = Color.DarkGray)
                // Recipe image
                Image(
                    painter = burgerImg,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                // Recipe text
                Text("Cook burger, stack toppings in a bun, voila!")
            }
        }
    }

    @Preview
    @Composable
    fun pizza() {
        val pizzaImg = painterResource(id = R.drawable.pizza)
        Box (modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp)
            .padding(10.dp)){
            Column {
                // Recipe title
                Text("Pizza", color = Color.DarkGray)
                // Recipe image
                Image(
                    painter = pizzaImg,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                // Recipe text
                Text("Stack toppings on a pizza, voila!")
            }
        }
    }
}