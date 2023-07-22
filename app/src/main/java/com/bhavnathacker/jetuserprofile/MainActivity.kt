package com.bhavnathacker.jetuserprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserProfile()
                }
            }
        }
    }
}

@Composable
fun UserProfile() {
    //Text("Hello World!")
    var isClicked by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        UserImage(modifier = Modifier.size(160.dp))
        Divider(thickness = 2.dp)
        Text(text = "Bhavna Thacker", style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Android Developer", style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.secondary)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { isClicked = !isClicked }) {
           Text(text = "Profile")
        }

        if(isClicked) {
            Profile(getProfileEntries())
        }
    }
}

@Composable
fun Profile(entries: List<ProfileEntry>) {
    LazyColumn {
        items(entries) { entry ->
            ProfileCard(entry)
        }
    }
}

@Composable
fun ProfileCard(entry: ProfileEntry) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RectangleShape
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
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user_profile),
            contentDescription = stringResource(id = R.string.app_name)
        )
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfile()
}