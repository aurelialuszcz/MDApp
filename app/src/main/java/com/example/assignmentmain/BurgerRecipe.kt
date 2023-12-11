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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
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
            val background = painterResource(id = R.drawable.background)
            Surface(modifier = Modifier.fillMaxSize()) {
                // Background
                Image(
                    painter = background,
                    contentDescription = "background",
                    contentScale = ContentScale.FillHeight,
                )

                Parallax()
            }
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
            Column(modifier = Modifier
                .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))) {
                Text(
                    "Beef burger",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 32.sp
                )
                Text(
                    "Ingredients",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    "1 small onion, diced\n" +
                            "500g good-quality beef mince\n" +
                            "1 egg\n" +
                            "1 tbsp vegetable oil\n" +
                            "4 burger buns",
                    modifier = Modifier.padding(2.dp), color = Color.White
                )
                Text(
                    "Steps",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    "STEP 1\n" +
                            "Tip 500g beef mince into a bowl with 1 small diced onion and 1 egg, then mix.\n" +
                            "\n" +
                            "STEP 2\n" +
                            "Divide the mixture into four. Lightly wet your hands. Carefully roll the mixture into balls, each about the size of a tennis ball.\n" +
                            "\n" +
                            "STEP 3\n" +
                            "Set in the palm of your hand and gently squeeze down to flatten into patties about 3cm thick. Make sure all the burgers are the same thickness so that they will cook evenly.\n" +
                            "\n" +
                            "STEP 4\n" +
                            "Put on a plate, cover with cling film and leave in the fridge to firm up for at least 30 mins.\n" +
                            "\n" +
                            "STEP 5\n" +
                            "Heat the barbecue to medium hot (there will be white ash over the red hot coals – about 40 mins after lighting). Lightly brush one side of each burger with vegetable oil.\n" +
                            "\n" +
                            "STEP 6\n" +
                            "Place the burgers, oil-side down, on the barbecue. Cook for 5 mins until the meat is lightly charred. Don’t move them around or they may stick.\n" +
                            "\n" +
                            "STEP 7\n" +
                            "Oil the other side, then turn over using tongs. Don’t press down on the meat, as that will squeeze out the juices.\n" +
                            "\n" +
                            "STEP 8\n" +
                            "Cook for 5 mins more for medium. If you like your burgers pink in the middle, cook 1 min less each side. For well done, cook 1 min more.\n" +
                            "\n" +
                            "STEP 9\n" +
                            "Take the burgers off the barbecue. Leave to rest on a plate so that all the juices can settle inside.\n" +
                            "\n" +
                            "STEP 10\n" +
                            "Slice four burger buns in half. Place, cut-side down, on the barbecue rack and toast for 1 min until they are lightly charred. Place a burger inside each bun, then top with your choice of accompaniment.",
                    modifier = Modifier.padding(2.dp), color = Color.White
                )

            }
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