package com.charity.loginreg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charity.loginreg.ui.theme.LoginRegTheme

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Greeting("Android")
                    Calc()
                }
            }
        }
    }
}

@Composable
fun Calc(){
    var firstnumber by remember { mutableStateOf(TextFieldValue(""))}
    var secondnumber by remember { mutableStateOf(TextFieldValue(""))}
    var answer by remember { mutableStateOf("")}
    val context = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) ){
        Text(text = "Calculator",
            color= Color.Magenta,
            fontSize = 30.sp,

        )
        Text(text = "Click to go to intent",
            modifier = Modifier.clickable {
                val intent = Intent(context, IntentActivity::class.java)
                context.startActivity(intent)

            })


        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = firstnumber,
            onValueChange = {firstnumber=it},
            label = {
                Text(text = "Enter First No.",
                    color = Color.Magenta,
                    fontSize = 30.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = secondnumber,
            onValueChange = {secondnumber=it},
            label = {
                Text(text = "Enter Second No.",
                    color = Color.Magenta,
                    fontSize = 30.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedButton(
            onClick = {
                val myfirstnum= firstnumber.text.trim()
                val mysecondnum= secondnumber.text.trim()
                answer = if (myfirstnum.isEmpty()&&mysecondnum.isEmpty()){
                    "Please fill in all the details"
                }else{
                    val myanswer= myfirstnum.toDouble() + mysecondnum.toDouble()
                    myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = ButtonDefaults.shape,
            border = BorderStroke(4.dp, Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.45f),

            ) {
            Text(text = "+",
                color = Color.White,
                fontSize = 30.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val myfirstnum= firstnumber.text.trim()
                val mysecondnum= secondnumber.text.trim()
                answer = if (myfirstnum.isEmpty()&&mysecondnum.isEmpty()){
                    "Please fill in all the details"
                }else{
                    val myanswer= myfirstnum.toDouble() - mysecondnum.toDouble()
                    myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = ButtonDefaults.shape,
            border = BorderStroke(4.dp, Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.45f),
        ) {
            Text(text = "-",
                color = Color.White,
                fontSize = 30.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val myfirstnum= firstnumber.text.trim()
                val mysecondnum= secondnumber.text.trim()
                answer = if (myfirstnum.isEmpty()&&mysecondnum.isEmpty()){
                    "Please fill in all the details"
                }else{
                    val myanswer= myfirstnum.toDouble() * mysecondnum.toDouble()
                    myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = ButtonDefaults.shape,
            border = BorderStroke(4.dp, Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.45f),

        ) {
            Text(text = "*",
                color = Color.White,
                fontSize = 30.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = {
                val myfirstnum= firstnumber.text.trim()
                val mysecondnum= secondnumber.text.trim()
                answer = if (myfirstnum.isEmpty()&&mysecondnum.isEmpty()){
                    "Please fill in all the details"
                }else{
                    val myanswer= myfirstnum.toDouble() / mysecondnum.toDouble()
                    myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            shape = ButtonDefaults.shape,
            border = BorderStroke(4.dp, Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.45f),

        ) {
            Text(text = "/",
                color = Color.White,
                fontSize = 30.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = answer,
            onValueChange = {answer=it},
            label = {
                Text(text = answer,
                    color = Color.Magenta,
                    fontSize = 30.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )


    }

}

@Preview(showBackground = true)
@Composable
private fun Calcprev(){
    Calc()

}