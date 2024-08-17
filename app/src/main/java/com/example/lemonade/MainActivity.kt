package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(value = 1)
    }
    when (counter) {
        1 -> ImageAndText(
            image = R.drawable.lemon_tree,
            title = R.string.lemon_tree,
            buttonFunc = {
                counter = 2
            }
        )
        2 -> ImageAndText(
            image = R.drawable.lemon_squeeze,
            title = R.string.lemon,
            buttonFunc = {
                counter = 3
            }
        )
        3 -> ImageAndText(
            image = R.drawable.lemon_drink,
            title = R.string.glass_of_lemonade,
            buttonFunc = {
                counter = 4
            }
        )
        4 -> ImageAndText(
            image = R.drawable.lemon_restart,
            title = R.string.empty_glass,
            buttonFunc = {
                counter = 1
            }
        )
    }
}

@Composable
fun ImageAndText(
    image: Int,
    title: Int,
    buttonFunc: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            onClick = buttonFunc,
            shape = RoundedCornerShape(topStart = 50.dp, bottomEnd = 50.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = title)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = stringResource(id = title))
    }
}