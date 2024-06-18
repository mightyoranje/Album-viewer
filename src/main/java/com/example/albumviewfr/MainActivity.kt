package com.example.albumviewfr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albumviewfr.ui.theme.AlbumviewfrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlbumviewfrTheme {
                    Greeting()
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    val imagestuff = when(result){
        1-> painterResource(id = R.drawable.img_20190621_183921)
        2-> painterResource(id = R.drawable._020_05_10_01_18_41_893)
        3-> painterResource(id = R.drawable._0191225467445195)
        else -> painterResource(id = R.drawable.ic_launcher_background)
    }
    val informationstuff = when(result){
        1-> "Swimming"
        2-> "Random Drawing"
        3-> "Candid Pic"
        else-> "You've reached the End"
    }
    Box(modifier = modifier
        .fillMaxSize()
        .offset(y = ((-100).dp))
        .wrapContentSize()){
        Image(
            painter = imagestuff,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .heightIn(0.dp, 400.dp)
                .widthIn(0.dp, 350.dp)
                .border(20.dp, Color.White)
                .shadow(10.dp)
                .padding(20.dp)
        )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.fillMaxSize().offset( y = ((-50).dp))){
        Box(
            modifier = modifier
                .padding(20.dp)
                .background(color = Color.LightGray)
                .width(350.dp)
        ) {
            Text(
                text = "$informationstuff \n2019",
                modifier = modifier.padding(20.dp),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                result -= 1
                if (result == 0) {
                    result = 1
                }},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                Text(
                    text = "Back",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Button(
                onClick = {
                    result += 1
                    if (result > 4) {
                        result = 4
                    } },
                modifier = modifier,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
            ) {
                Text(
                    text = "Next",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlbumviewfrTheme {
        Greeting()
    }
}