package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
    @Preview
    @Composable
    fun Burger() {
        val burgerImg = painterResource(id = R.drawable.burger)
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize(Alignment.Center)
                ) {
                    // Recipe image as the background
                    Image(
                        painter = burgerImg,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    // Column for title and button
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Recipe title
                        Text(
                            "Beef burger",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        // Spacer to push the button to the bottom
                        Spacer(modifier = Modifier.weight(1f))

                        // Button at the bottom center
                        Button(
                            onClick = { startActivity(burgerRecipe()) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Text("See more")
                        }
                    }
                }
            }
        )
    }

    // Function to create pizza card
    @Preview
    @Composable
    fun Pizza() {
        val pizzaImg = painterResource(id = R.drawable.pizza)
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize(Alignment.Center)
                ) {
                    // Recipe image as the background
                    Image(
                        painter = pizzaImg,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    // Column for title and button
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Recipe title
                        Text(
                            "Pizza dough",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        // Spacer to push the button to the bottom
                        Spacer(modifier = Modifier.weight(1f))

                        // Button at the bottom center
                        Button(
                            onClick = { startActivity(pizzaRecipe()) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Text("See more")
                        }
                    }
                }
            }
        )
    }

    // Function to create pasta card
    @Preview
    @Composable
    fun Pasta() {
        val pastaImg = painterResource(id = R.drawable.pasta)
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize(Alignment.Center)
                ) {
                    // Recipe image as the background
                    Image(
                        painter = pastaImg,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    // Column for title and button
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Recipe title
                        Text(
                            "Pasta dough",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        // Spacer to push the button to the bottom
                        Spacer(modifier = Modifier.weight(1f))

                        // Button at the bottom center
                        Button(
                            onClick = { startActivity(pastaRecipe()) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Text("See more")
                        }
                    }
                }
            }
        )
    }
    // Function to create pasta card
    @Preview
    @Composable
    fun Hummus() {
        val hummusImg = painterResource(id = R.drawable.hummus)
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .padding(5.dp)
                .wrapContentSize(Alignment.Center),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize(Alignment.Center)
                ) {
                    // Recipe image as the background
                    Image(
                        painter = hummusImg,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    // Column for title and button
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Recipe title
                        Text(
                            "Barbie hummus",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        // Spacer to push the button to the bottom
                        Spacer(modifier = Modifier.weight(1f))

                        // Button at the bottom center
                        Button(
                            onClick = { startActivity(hummusRecipe()) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Text("See more")
                        }
                    }
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