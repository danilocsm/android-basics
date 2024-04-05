package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
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

@Composable
fun AppBody(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        AppMainImage()
        TextTitle(title = stringResource(R.string.title_text))
        FirstParagraph(text = stringResource(R.string.first_paragraph_text))
        SecondParagraph(text = stringResource(R.string.second_paragraph_text))
    }
}

@Composable
fun AppMainImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
}

@Composable
fun FirstParagraph(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Justify, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
}

@Composable
fun SecondParagraph(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        AppBody()
    }
}