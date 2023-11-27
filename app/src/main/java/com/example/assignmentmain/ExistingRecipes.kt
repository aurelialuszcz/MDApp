package com.example.assignmentmain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ExistingRecipes : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Column {
                    title()
                }
                FlowRow(
                    //verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(2.dp)
                ) {
                    burger()
                    pizza()
                    pasta()
                    hummus()
                }
            }
        }
    //}

    // Function to create title of the page
    @Composable
    fun title() {
        Text("Recipes",
            color = Color.DarkGray,
            fontFamily = FontFamily.Serif,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp))
    }

    // Burger card
    @Preview
    @Composable
    fun burger() {
        val burgerImg = painterResource(id = R.drawable.burger)
        Card(modifier = Modifier
            .width(220.dp)
            .height(220.dp)
            .padding(5.dp)
            .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text("Burger", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                // Recipe image
                Image(
                    painter = burgerImg,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        //.clip(CircleShape),
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { }) {
                    Text("See more")
                }
                }
        )
        }
    }

    // Pizza card
    @Preview
    @Composable
    fun pizza() {
        val pizzaImg = painterResource(id = R.drawable.pizza)
        Card(modifier = Modifier
            .width(220.dp)
            .height(220.dp)
            .padding(5.dp)
            .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text("Pizza", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                // Recipe image
                Image(
                    painter = pizzaImg,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        //.clip(CircleShape),
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { }) {
                    Text("See more")
                }
        })
    }

// Pasta card
@Preview
@Composable
fun pasta() {
    val pastaImg = painterResource(id = R.drawable.pasta)
    Card(modifier = Modifier
        .width(220.dp)
        .height(220.dp)
        .padding(10.dp)
        .wrapContentSize(Alignment.Center),
        content = {
            // Recipe title
            Text("Pasta", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            // Recipe image
            Image(
                painter = pastaImg,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    //.clip(CircleShape)
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.FillWidth
            )
            Button(onClick = { }) {
                Text("See more")
            }
        })
}

// Hummus card
@Preview
@Composable
fun hummus() {
    val hummusImg = painterResource(id = R.drawable.hummus)
    Card(modifier = Modifier
        .width(220.dp)
        .height(220.dp)
        .padding(10.dp)
        .wrapContentSize(Alignment.Center),
        content = {
            // Recipe title
            Text("Beetroot hummus", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            // Recipe image
            Image(
                painter = hummusImg,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .aspectRatio(16f / 9f),
                    //clip(CircleShape),
                contentScale = ContentScale.FillWidth
            )
            Button(onClick = { }) {
                Text("See more")
            }
        })
}