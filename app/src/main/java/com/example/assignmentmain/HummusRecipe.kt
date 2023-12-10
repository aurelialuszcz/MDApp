package com.example.assignmentmain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

class HummusRecipe : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val background = painterResource(id = R.drawable.background)
            Surface(modifier = Modifier.fillMaxSize()) {
                // Background
                Image(
                    painter = background,
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )
                ParallaxHummus()
            }
        }
    }
}

@Preview
@Composable
private fun ParallaxHummus() {
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
                    painter = painterResource(id = R.drawable.hummus),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Text("Beetroot hummus",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = Color.White, fontSize = 32.sp)
            Text("Ingredients",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = Color.White, fontSize = 18.sp)
            Text("1 can chickpeas (430 g/15 oz), drained and rinsed\n" +
                    "2 medium cooked beetroots (read above post on how to cook them), cut into quarters\n" +
                    "2 cloves garlic\n" +
                    "zest and juice from 1 medium lemon\n" +
                    "2-3 tablespoons tahini\n" +
                    "2-3 tablespoons olive oil\n" +
                    "¼ teaspoon salt\n" +
                    "½ teaspoon ground cumin",
                modifier = Modifier.padding(2.dp), color = Color.White)
            Text("Steps",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), color = Color.White, fontSize = 18.sp)
            Text("Step 1: Place the beetroots, chickpeas and garlic into a food processor and process for 1 minute until ground. Add all the remaining ingredients and process until creamy. It should have some grainy texture, that’s ok. If it’s dry or you want to thin it out and make it more creamy, add more tahini or water, until you like the consistency.\n" + "\n" +
                    "Step 2: Adjust seasonings, adding more salt, cumin, olive oil, or lemon juice if needed.\n" + "\n" +
                    "Step 3: Scrape into a serving bowl to use immediately. I like to serve it at room temperature. Refrigerate in an airtight container if you aren't serving right away.\n" + "\n" +
                    "Beetroot hummus will keep in the fridge, covered well, for 4-5 days.",
                modifier = Modifier.padding(2.dp), color = Color.White)
        }

        Box (modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .graphicsLayer {
                alpha = min(1f, (scrollState.value.toFloat() / scrollState.maxValue.toFloat()))
            }
            .background(color = Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Beetroot hummus")
        }
    }
}