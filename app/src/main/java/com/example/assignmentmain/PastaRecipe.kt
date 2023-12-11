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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.min

class PastaRecipe : ComponentActivity() {
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
                ParallaxPasta()
            }
        }
    }
}

@Preview
@Composable
private fun ParallaxPasta() {
    val scrollState = rememberScrollState()

    Box{
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {

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
                    painter = painterResource(id = R.drawable.pasta),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Text(
                    "Homemade pasta",
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
                    "2 cups all-purpose flour, spooned & leveled\n" +
                            "3 large eggs\n" +
                            "½ teaspoon sea salt\n" +
                            "½ tablespoon extra-virgin olive oil",
                    modifier = Modifier.padding(2.dp), color = Color.White
                )
                Text(
                    "Steps",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    "Step 1: Place the flour on a clean work surface and make a nest. Add the eggs, olive oil, and salt to the center and use a fork to gently break up the eggs, keeping the flour walls intact as best as you can. Use your hands to gently bring the flour inward to incorporate. Continue working the dough with your hands to bring it together into a shaggy ball.\n" + "\n" +
                            "Step 2: Knead the dough for 8 to 10 minutes. At the beginning, the dough should feel pretty dry, but stick with it! It might not feel like it’s going to come together, but after 8-10 minutes of kneading, it should become cohesive and smooth. If the dough still seems too dry, sprinkle your fingers with a tiny bit of water to incorporate. If it’s too sticky, dust more flour onto your work surface. Shape the dough into a ball, wrap in plastic wrap, and let rest at room temperature for 30 minutes.\n" + "\n" +
                            "Step 3: Dust 2 large baking sheets with flour and set aside.\n" + "\n" +
                            "Step 4: Slice the dough into four pieces. Gently flatten one into an oval disk. Run the dough through the Pasta Roller Attachment or a pasta maker three times on level 1 (the widest setting).\n" + "\n" +
                            "Step 5: Set the dough piece onto a countertop or work surface. Fold both short ends in to meet in the center, then fold the dough in half to form a rectangle (see photo above).\n" + "\n" +
                            "Step 6: Run the dough through the pasta roller three times on level 2, three times on level 3, and one time each on levels 4, 5, and 6.\n" + "\n" +
                            "Step 7: Lay half of the pasta sheet onto the floured baking sheet and sprinkle with flour before folding the other half on top. Sprinkle more flour on top of the second half. Every side should be floured so that your final pasta noodles won't stick together.\n" + "\n" +
                            "Step 8: Repeat with remaining dough.\n" + "\n" +
                            "Step 9: Run the pasta sheets through the Pasta Cutter Attachment (pictured is the fettuccine cutter). Repeat with remaining dough. Cook the pasta in a pot of salted boiling water for 1 to 2 minutes.",
                    modifier = Modifier.padding(2.dp), color = Color.White
                )
            }
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
            Text(text = "Homemade pasta")
        }
    }
}