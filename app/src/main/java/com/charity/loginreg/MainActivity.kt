package com.charity.loginreg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charity.loginreg.ui.theme.LoginRegTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 //   Greeting("Android")
                    Login()


                }
            }
        }
    }
}

@Composable
fun Login(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column ( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp)){
        Text(text = "eMobilis Login",
            color = Color.Magenta,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "icon" ) },
            label = { Text(text = "Enter Email",
                color = Color.Magenta,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lock" ) },
            label = { Text(text = "Enter Password",
                color = Color.Magenta,
                fontSize = 20.sp
            )},

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)) {
            Text(text ="Log In",
                fontSize = 20.sp,
                color = Color.DarkGray
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)) {
            Text(text ="Click to register",
                fontSize = 20.sp,
                color = Color.DarkGray
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, IntentActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        )
        {
            Text(
                text = "Intents",
                fontSize = 20.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, CalculatorActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        )
        {
            Text(
                text = "Calculator",
                fontSize = 20.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, SimplelistviewActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        )
        {
            Text(
                text = "List View",
                fontSize = 20.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context,CustomlistActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        )
        {
            Text(
                text = "Custom List",
                fontSize = 20.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val intent = Intent(context, RecyclerviewActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        )
        {
            Text(
                text = "Recycler view",
                fontSize = 20.sp,
                color = Color.DarkGray
            )
        }


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Loginpre() {
    Login()


}
