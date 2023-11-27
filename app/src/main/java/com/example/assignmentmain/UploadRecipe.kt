package com.example.assignmentmain

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UploadRecipe : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                uri.value = it
                has_image.value = true
            }
            Box(modifier = Modifier.fillMaxSize()) {
                // Window title
                Column (
                    modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    Text("Recipe Upload",
                        color = Color.DarkGray,
                        fontFamily = FontFamily.Serif,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp))
                }

                // Uploading image + text
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    )
                {
                    TextField(value = recipe_text.value, onValueChange = {recipe_text.value = it},
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color = Color.Gray))
                    // Image upload button
                    Button(onClick = { launcher.launch("image/*") },
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color = Color.Gray)) {
                        Text("Upload", color = Color.White)
                    }
                    // Text upload button
                    Button(onClick = {enterRecipe()},
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color = Color.Gray)) {
                        Text("Submit", color = Color.White)
                    }
                    if (has_image.value)
                        Image(bitmap = getImageBitmap(uri.value), contentDescription = null,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(200.dp))
                    Text("${entered_text.value}", color = Color.White)
                    }
                }
            }
        }


    // Function to access image folder
    private fun getImageBitmap(image_uri: Uri?): ImageBitmap {
        if(Build.VERSION.SDK_INT >= 28) {
            var source = ImageDecoder.createSource(contentResolver, image_uri!!)
            return ImageDecoder.decodeBitmap(source).asImageBitmap()
        } else {
            return MediaStore.Images.Media.getBitmap(contentResolver, image_uri!!).asImageBitmap()
        }
    }
    // Function to show the entered text to the screen
    fun enterRecipe() {
        entered_text.value = recipe_text.value
    }

    var has_image = mutableStateOf(false)
    var uri = mutableStateOf<Uri?>(null)
    var recipe_text = mutableStateOf("Enter your recipe here!")
    var entered_text = mutableStateOf(" ")
}
