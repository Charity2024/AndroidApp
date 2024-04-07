package com.charity.loginreg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charity.loginreg.ui.theme.LoginRegTheme

class CustomlistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                //    Greeting2("Android")
                    Custom()

                }
            }
        }
    }
}

data class SpaceModel(val name:String, val image : Int)
@Composable
fun SpaceRow(model: SpaceModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

    val spaceList = mutableListOf<SpaceModel>().apply {
        add(SpaceModel("Moon", R.drawable.moon))
        add(SpaceModel("Earth", R.drawable.earth))
        add(SpaceModel("Clouds", R.drawable.cloud))
        add(SpaceModel("Saturn", R.drawable.saturn))
        add(SpaceModel("Venus", R.drawable.venus))
        add(SpaceModel("Jupiter", R.drawable.jupiter))
        add(SpaceModel("Neptune", R.drawable.neptune))
        add(SpaceModel("Mercury", R.drawable.mercury))
    }
@Composable
fun Custom() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(spaceList) { model ->
            SpaceRow(model = model)
        }
    }

}
@Preview
@Composable
 private fun Customprev(){
    Custom()
}
