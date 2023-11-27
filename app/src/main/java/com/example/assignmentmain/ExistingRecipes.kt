package com.example.assignmentmain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ExistingRecipes : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
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
        val burgerImg = painterResource(id = R.drawable.burger2)
        Card(modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp)
            .padding(10.dp)
            .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text("Burger", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                // Recipe image
                Image(
                    painter = burgerImg,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp).clip(CircleShape),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { }) {
                    Text("See more")
                }
                }
        )
        }
    }

    @Preview
    @Composable
    fun pizza() {
        val pizzaImg = painterResource(id = R.drawable.pizza)
        Card(modifier = Modifier
            .background(Color.LightGray)
            .width(250.dp)
            .height(250.dp)
            .padding(10.dp)
            .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text("Pizza", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                // Recipe image
                Image(
                    painter = pizzaImg,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp).clip(CircleShape),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { }) {
                    Text("See more")
                }
        })
    }

@Preview
@Composable
fun pasta() {
    val pastaImg = painterResource(id = R.drawable.pasta)
    Card(modifier = Modifier
        .background(Color.LightGray)
        .width(250.dp)
        .height(250.dp)
        .padding(10.dp)
        .wrapContentSize(Alignment.Center),
        content = {
            // Recipe title
            Text("Pasta", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            // Recipe image
            Image(
                painter = pastaImg,
                contentDescription = null,
                modifier = Modifier.size(150.dp).clip(CircleShape),
                contentScale = ContentScale.FillWidth
            )
            Button(onClick = { }) {
                Text("See more")
            }
        })
}