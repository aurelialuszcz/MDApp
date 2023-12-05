package com.example.assignmentmain

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
class ExistingRecipes : ComponentActivity() {
      @OptIn(ExperimentalLayoutApi::class)
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
                FlowRow(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Title()
                    Burger()
                    //Burger()
                    //Burger()
                    //Burger()
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
                // Recipe title
                Text(
                    "Burger",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
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
                Button(onClick = { startActivity(burgerRecipe()) }) {
                    Text("See more")
                }
            }
        )
    }

    private fun burgerRecipe(): Intent {
        val intent = Intent(this, RecipeWindow::class.java)

        return intent
    }
}