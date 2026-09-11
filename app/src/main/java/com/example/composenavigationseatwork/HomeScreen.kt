package com.example.composenavigationseatwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onViewDetailsClick: () -> Unit = {}
) {
    var loginAttempts by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Name: Andrea Maglalang", modifier = Modifier.padding(top = 16.dp))
        Text(text = "Course: BS Computer Engineering", modifier = Modifier.padding(top = 4.dp))
        Text(text = "Year: 4", modifier = Modifier.padding(top = 4.dp))

        Button(
            onClick = { onViewDetailsClick() },
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("View Details")
        }

        Text(text = "Login Attempts: $loginAttempts", modifier = Modifier.padding(top = 32.dp))

        Button(
            onClick = { loginAttempts++ },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Attempt")
        }
    }
}