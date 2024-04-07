package com.charity.loginreg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charity.loginreg.ui.theme.LoginRegTheme

class RegisterActivity : ComponentActivity() {
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
                    Register()
                }
            }
        }
    }
}

@Composable
fun Register(){
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 10.dp)) {
        Text(
            text = "eMobilis Signup",
            color = Color.Magenta,
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
        )

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "icon" ) },
            label = {
                Text(
                    text = "FirstName",
                    color = Color.DarkGray,
                    fontSize = 20.sp,

                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "icon" ) },
            label = {
                Text(
                    text = "Email",
                    color = Color.DarkGray,
                    fontSize = 20.sp

                )

            }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "icon" ) },
            label = {
                Text(
                    text = "Enter Password",
                    color = Color.DarkGray,
                    fontSize = 20.sp

                )
            }
        )
        OutlinedTextField(
            value = confirm,
            onValueChange = { confirm = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "icon" ) },
            modifier = Modifier,
            label = {
                Text(
                    text = "Confirm Password",
                    color = Color.DarkGray,
                    fontSize = 20.sp

                )
            }
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 350.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.3f),

            )
        {
            Text(text = "Register")

        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                val intent= Intent (context, MainActivity::class.java)
                context.startActivity(intent)
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Log In")

        }


    }
}


@Preview
@Composable
private fun Registerprev(){
    Register()

}