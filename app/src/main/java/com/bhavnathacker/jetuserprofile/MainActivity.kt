package com.bhavnathacker.jetuserprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bhavnathacker.jetuserprofile.ui.theme.JetUserProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetUserProfileTheme {
                UserProfile()
            }
        }
    }
}

@Composable
fun UserProfile() {
    var isClicked by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserImage(modifier = Modifier.size(160.dp))
                Divider(thickness = 2.dp)
                Text(
                    "Bhavna Thacker",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.primaryVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { isClicked = !isClicked },
                ) {
                    Text(text = "Profile")
                }

                if (isClicked) {
                    Profile(getProfileEntries())
                }
            }
        }
    }
}

@Composable
fun Profile(entries: List<ProfileEntry>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        LazyColumn {
            items(entries) { entry ->
                ProfileCard(entry)
            }
        }
    }

}

@Composable
fun ProfileCard(entry: ProfileEntry) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RectangleShape, elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserImage(modifier = Modifier.size(100.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = entry.name)
                Text(text = entry.value)
            }
        }
    }
}

@Composable
private fun UserImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .padding(8.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Gray),
        elevation = 2.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user_profile),
            contentDescription = stringResource(id = R.string.user_image)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetUserProfileTheme {
        UserProfile()
    }
}