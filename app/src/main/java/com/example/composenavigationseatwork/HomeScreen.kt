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
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Name: Andrea Maglalang")
        Text(text = "Course: BS Computer Engineering")
        Text(text = "Year: 4")

        Button(
            onClick = { onViewDetailsClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Details")
        }

        Text(text = "Login Attempts: $loginAttempts")

        Button(
            onClick = { loginAttempts++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Attempt")
        }
    }
}