package com.example.composenavigationseatwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Student ID: 1001", modifier = Modifier.padding(top = 16.dp))
        Text(text = "Name: Andrea Maglalang", modifier = Modifier.padding(top = 4.dp))
        Text(text = "Course: BS Computer Engineering", modifier = Modifier.padding(top = 4.dp))
        Text(text = "Year: 4", modifier = Modifier.padding(top = 4.dp))

        Button(
            onClick = { onBackClick() },
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Back")
        }
    }
}