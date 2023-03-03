package com.example.marsroverphotos

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterResults(){
    Column(modifier = Modifier
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {


        Text(text = "Martian date(Sol): ")
        Text(text = "Page: " )

        Spacer(modifier = Modifier.weight(1f))


        Row(horizontalArrangement = Arrangement.Center) {
//            Text(text = "test")

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(30.dp)
                    .height(50.dp)
                    .width(200.dp)
                    .align(Alignment.CenterVertically)
            ){

                Text(text = "Apply")
            }
        }




    }
}