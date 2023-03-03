package com.example.marsroverphotos

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.navigation.Screen

@Composable
fun FilterResults(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {


        Spacer(modifier = Modifier.height(150.dp))



        Text(text = "Martian date(Sol): ")

        var sol by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = sol,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { newText ->
                sol = newText
            }
        )


        Spacer(modifier = Modifier.height(90.dp))

        Text(text = "Page: " )

        var page by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = page,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { newText ->
                page = newText
            }
        )


        Spacer(modifier = Modifier.weight(1f))


        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Button(
                onClick = {
                          navController.navigate(Screen.MainScreen.route)
                },
                modifier = Modifier
                    .padding(30.dp)
                    .height(50.dp)
                    .width(200.dp)
            ){

                Text(text = "Apply")
            }
        }




    }
}