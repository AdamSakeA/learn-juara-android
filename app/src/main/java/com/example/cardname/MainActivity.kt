package com.example.cardname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardname.ui.theme.CardNameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardNameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardNameApp()
                }
            }
        }
    }
}

@Composable
fun CardNameApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        ComposeHeader(
            fullName = stringResource(R.string.full_name),
            title = stringResource(R.string.title),
            image = painterResource(R.drawable.ic_launcher_foreground)
        )
        ComposeFooter(
            phoneNumber = stringResource(R.string.phone_number),
            email = stringResource(R.string.email),
            socialMedia = stringResource(R.string.social_media)
        )
    }
}

@Composable
private fun ComposeHeader(
    fullName: String,
    title: String,
    image: Painter,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image, contentDescription = "Profile Picture")
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(text = title)
    }
}

@Composable
private fun ComposeFooter(
    phoneNumber: String,
    email: String,
    socialMedia: String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,

    ) {
        Row(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Icon(Icons.Filled.Phone, contentDescription = null)
            Text(
                text = phoneNumber,
                modifier = Modifier.padding(start = 30.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Icon(Icons.Filled.Share, contentDescription = null)
            Text(
                text = socialMedia,
                modifier = Modifier.padding(start = 30.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Icon(Icons.Filled.Email, contentDescription = null)
            Text(
                text = email,
                modifier = Modifier.padding(start = 30.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardNamePreview() {
    CardNameTheme {
        CardNameApp()
    }
}

