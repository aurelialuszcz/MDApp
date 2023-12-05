package com.example.assignmentmain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentmain.ui.theme.AssignmentMainTheme
import kotlin.math.min
import androidx.compose.ui.unit.min as min

class BurgerRecipe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val burger = painterResource(id = R.drawable.burger)
            val background = painterResource(id = R.drawable.background)
            Surface(modifier = Modifier.fillMaxSize()) {
                // Background
                Image(
                    painter = background,
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )

                Parallax()
            }/*
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Recipe title
                    Text(
                        "Burger",
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    // Recipe image
                    Image(
                        painter = burger,
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .aspectRatio(16f / 9f),
                        contentScale = ContentScale.FillWidth
                    )
                    // Recipe text
                    Text("Burger recipe goes here", color = Color.White)
                }
            }*/
        }
    }
}

@Composable
fun Parallax() {
    val scrollState = rememberScrollState()

    Box{
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .graphicsLayer {
                        alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                        translationY = 0.5f * scrollState.value
                    }, contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.burger),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Text("Beef burger",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = Color.White)

            Text("Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" +
                "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe" + "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe"
                +"Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe"+"Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe"+
                    "Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe"+"Beef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipeBeef recipe",
                modifier = Modifier.padding(8.dp), color = Color.White)

        }

        Box (modifier = Modifier
            .fillMaxWidth()
            .height(55.dp).graphicsLayer {
                                         alpha = min(1f, (scrollState.value.toFloat() / scrollState.maxValue.toFloat()))
            }.background(color = Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Beef burger")
        }
        }
    }