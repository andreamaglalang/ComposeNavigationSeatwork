package com.example.composenavigationseatwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigate: (String, String, String) -> Unit = { _, _, _ -> }
){
    var studentId by remember { mutableStateOf("") }
    var studentName by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var loginAttempts by remember { mutableIntStateOf(0) }
    var errorMessage by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Login Attempts: $loginAttempts",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { loginAttempts++ },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Add Attempt")
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = {
                studentId = ""
                studentName = ""
                course = ""
                loginAttempts = 0
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Clear")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                if (studentId.isBlank() || studentName.isBlank() || course.isBlank()){
                    errorMessage = "Student ID, Name, and Course are required."
                } else {
                    errorMessage = ""
                    showDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("View Details")
        }
    }

    if (showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirm Student Information") },
            text = { Text("View details for: $studentName?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onNavigate(studentId, studentName, course)
                    }
                ){
                    Text("Continue")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }){
                    Text("Cancel")
                }
            }
        )
    }
}