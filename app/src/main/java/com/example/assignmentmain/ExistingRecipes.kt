package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
class ExistingRecipes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val backgroundImg = painterResource(id = R.drawable.background)
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = backgroundImg,
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    // calling title composable
                    Title()
                    // calling card composable functions
                    Burger()
                    Pizza()
                    Pasta()
                    Hummus()
                }

            }
        }
    }

    // Function to create title of the page
    @Composable
    fun Title() {
        Text(
            "Recipes",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }

    // Function to create burger card
    @Composable
    fun Burger() {
        val burgerImg = painterResource(id = R.drawable.burger)
        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
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
                // Recipe title
                Text(
                    "Burger",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                    Button(onClick = { startActivity(burgerRecipe()) }) {
                        Text("See more")
                    }

            }
        )
    }

    // Function to create pizza card
    @Composable
    fun Pizza() {
        val pizzaImg = painterResource(id = R.drawable.pizza)
        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text(
                    "Homemade pizza",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
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
                Button(onClick = { startActivity(pizzaRecipe()) }) {
                    Text("See more")
                }
            }
        )
    }

    // Function to create pasta card
    @Composable
    fun Pasta() {
        val pastaImg = painterResource(id = R.drawable.pasta)
        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text(
                    "Homemade pasta",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                // Recipe image
                Image(
                    painter = pastaImg,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        //.clip(CircleShape),
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { startActivity(pastaRecipe()) }) {
                    Text("See more")
                }
            }
        )
    }
    // Function to create pasta card
    @Composable
    fun Hummus() {
        val hummusImg = painterResource(id = R.drawable.hummus)
        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                // Recipe title
                Text(
                    "Beetroot hummus",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                // Recipe image
                Image(
                    painter = hummusImg,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        //.clip(CircleShape),
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.FillWidth
                )
                Button(onClick = { startActivity(hummusRecipe()) }) {
                    Text("See more")
                }
            }
        )
    }

    // Intent to access burger recipe
    private fun burgerRecipe(): Intent {
        val intent = Intent(this, BurgerRecipe::class.java)

        return intent
    }

    // Intent to access pizza recipe
    private fun pizzaRecipe(): Intent {
        val intent = Intent(this, PizzaRecipe::class.java)

        return intent
    }

    // Intent to access pasta recipe
    private fun pastaRecipe(): Intent {
        val intent = Intent(this, PastaRecipe::class.java)

        return intent
    }

    // Intent to access hummus recipe
    private fun hummusRecipe(): Intent {
        val intent = Intent(this, HummusRecipe::class.java)

        return intent
    }
}