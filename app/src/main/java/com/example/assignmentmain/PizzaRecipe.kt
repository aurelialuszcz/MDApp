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

class PizzaRecipe : ComponentActivity() {
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
                ParallaxPizza()
            }
        }
    }
}

@Preview
@Composable
private fun ParallaxPizza() {
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
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .background(Color.DarkGray.copy(alpha = 0.6f)) // Transparent green background
                    .padding(20.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Text(
                    "Homemade pizza",
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
                    "1 and 1/3 cups (320ml) warm water (between 100-110°F, 38-43°C)\n" +
                            "2 and 1/4 teaspoons (7g) Platinum Yeast from Red Star instant yeast (1 standard packet)\n" +
                            "1 Tablespoon (13g) granulated sugar\n" +
                            "2 Tablespoons (30ml) olive oil, plus more for pan and brushing on dough\n" +
                            "1 teaspoon salt\n" +
                            "3 and 1/2 cups (about 450g) unbleached all-purpose flour (spooned & leveled), plus more for hands and surface\n" +
                            "sprinkle of cornmeal for dusting the pan",
                    modifier = Modifier.padding(2.dp), color = Color.White
                )
                Text(
                    "Steps",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    "Step 1: Whisk the warm water, yeast, and granulated sugar together in the bowl of your stand mixer fitted with a dough hook or paddle attachment. Cover and allow to rest for 5 minutes. *If you don’t have a stand mixer, simply use a large mixing bowl and mix the dough with a wooden spoon or rubber spatula in the next step.\n" + "\n" +
                            "Step 2: Add the olive oil, salt, and flour. Beat on low speed for 2 minutes. Turn the dough out onto a lightly floured surface. With lightly floured hands, knead the dough for 5 minutes (for a visual, watch me do it in the video above). The dough can be a little too heavy for a mixer to knead it, but you can certainly use the mixer on low speed instead. After kneading, the dough should still feel a little soft. Poke it with your finger – if it slowly bounces back, your dough is ready to rise. If not, keep kneading.\n" + "\n" +
                            "Step 3: Lightly grease a large bowl with oil or nonstick spray– just use the same bowl you used for the dough. Place the dough in the bowl, turning it to coat all sides in the oil. Cover the bowl with aluminum foil, plastic wrap, or a clean kitchen towel. Allow the dough to rise at room temperature for 60-90 minutes or until double in size. (Tip: For the warm environment on a particularly cold day, heat your oven to 150°F (66°C). Turn the oven off, place the dough inside, and keep the door slightly ajar. This will be a warm environment for your dough to rise. After about 30 minutes, close the oven door to trap the air inside with the rising dough. When it’s doubled in size, remove from the oven.)\n" + "\n" +
                            "Step 4: Preheat oven to 475°F (246°C). Allow it to heat for at least 15-20 minutes as you shape the pizza. (If using a pizza stone, place it in the oven to preheat as well.) Lightly grease baking sheet or pizza pan with nonstick spray or olive oil. Sprinkle lightly with cornmeal, which gives the crust extra crunch and flavor.\n" + "\n" +
                            "Step 5: Shape the dough: When the dough is ready, punch it down to release any air bubbles. Divide the dough in half. (If not making 2 pizzas, freeze half of the dough for another time. See freezing instructions below.) On a lightly floured work surface using lightly floured hands or rolling pin, gently flatten the dough into a disc. Place on prepared pan and, using lightly floured hands, stretch and flatten the disc into a 12-inch circle, about 1/2-inch thick. If the dough keeps shrinking back as you try to stretch it, stop what you’re doing, cover it lightly for 5-10 minutes, then try again. Once shaped into a 12-inch circle, lift the edge of the dough up to create a lip around the edges. I simply pinch the edges up to create the rim. If using a pizza stone, place the dough directly on baker’s peels dusted with cornmeal.\n" + "\n" +
                            "Step 6: Cover dough lightly with plastic wrap or a clean kitchen towel and allow to rest for a few minutes as you prepare your pizza toppings. I suggest pepperoni & green peppers or jalapeño slices, extra cheese pizza, Hawaiian pizza, pesto pizza, spinach artichoke white pizza, or homemade BBQ chicken pizza.\n" + "\n" +
                            "Step 7: Top & bake the pizza: Using your fingers, push dents into the surface of the dough to prevent bubbling. To prevent the filling from making your pizza crust soggy, brush the top lightly with olive oil. Top with your favorite toppings and bake for 13-15 minutes or until the crust is golden brown.",
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
            Text(text = "Homemade pizza")
        }
    }
}