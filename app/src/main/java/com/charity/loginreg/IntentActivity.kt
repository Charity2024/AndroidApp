package com.charity.loginreg

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.charity.loginreg.ui.theme.LoginRegTheme

class IntentActivity : ComponentActivity() {
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
                    IntentScreen()
                }
            }
        }
    }
}

@Composable
fun IntentScreen(){
    val context= LocalContext.current
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
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val uri = Uri.parse("smsto:07456789")

                val intent = Intent(Intent.ACTION_SENDTO, uri)

                intent.putExtra("Hello", "How is todays weather")

                context.startActivity(intent)
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "SMS")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Call")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val phone = "+34666777888"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                context.startActivity(intent)
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Dial")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                      val takePictureIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(context as Activity,takePictureIntent,1,null)
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Camera")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Share")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "stk/Mpesa")

        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                context.startActivity(Intent.createChooser(emailIntent, "Send email..."))

            },
            shape = ButtonDefaults.shape,
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier
                .fillMaxWidth(0.45f)
        )
        {
            Text(text = "Email")

        }



    }
}


@Preview(showBackground = true)
@Composable
private fun Intentprev(){
    IntentScreen()
}
