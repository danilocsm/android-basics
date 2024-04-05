package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppBody()

                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppBody() {
    val rows = 2
    val data = listOf<Triple<String, String, Color>>(
        Triple(
            stringResource(R.string.title_1), stringResource(
                R.string.content_1
            ), colorResource(R.color.quadrant_1)
        ),
        Triple(
            stringResource(R.string.title_2), stringResource(
                R.string.content_2
            ), colorResource(R.color.quadrant_2)
        ),
        Triple(
            stringResource(R.string.title_3), stringResource(
                R.string.content_3
            ), colorResource(R.color.quadrant_3)
        ),
        Triple(
            stringResource(R.string.title_4), stringResource(
                R.string.content_4
            ), colorResource(R.color.quadrant_4)
        ),
    )
    FlowRow(
        maxItemsInEachRow = rows,
    ) {
        for (item in data) {
            Quadrant(title = item.first, textContent = item.second, backgroundColor = item.third)
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    textContent: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(0.5F)
            .background(color = backgroundColor)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = textContent, textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        AppBody()
    }
}
