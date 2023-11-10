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
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap

class SecondWindow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                uri.value = it
                has_image.value = true
            }

            Column {
                Text("Insert your recipe here!")
                Text("Upload your image!")
                Button(onClick = { launcher.launch("image/*")}) {
                    Text("Upload")
                }
                if(has_image.value)
                    Image(bitmap = getImageBitmap(uri.value), contentDescription = null)
            }
        }
    }

    private fun getImageBitmap(image_uri: Uri?): ImageBitmap {
        if(Build.VERSION.SDK_INT >= 28) {
            var source = ImageDecoder.createSource(contentResolver, image_uri!!)
            return ImageDecoder.decodeBitmap(source).asImageBitmap()
        } else {
            return MediaStore.Images.Media.getBitmap(contentResolver, image_uri!!).asImageBitmap()
        }
    }

    var has_image = mutableStateOf(false)
    var uri = mutableStateOf<Uri?>(null)

}
