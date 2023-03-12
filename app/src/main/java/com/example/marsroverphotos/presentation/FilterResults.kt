package com.example.marsroverphotos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marsroverphotos.presentation.main_screen.MainScreenViewModel
import com.example.marsroverphotos.ui.theme.*

@Composable
fun FilterResults(navController: NavController, viewModel: MainScreenViewModel = hiltViewModel()){

    var sol by remember { mutableStateOf(TextFieldValue("")) }

    var page by remember { mutableStateOf(TextFieldValue("")) }






    Column(modifier = Modifier
        .fillMaxSize()
        .background(BlackBean1),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {


        Spacer(modifier = Modifier.height(150.dp))


        Box(modifier = Modifier
            .padding(22.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(110.dp)
            .background(color = ChocolateCosmos),
        ){

            Text(text = "Martian date (Sol): ",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
                        color = Peach,
                fontFamily = bebasNeueFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )

            BasicTextField(
                value = sol,
            modifier = Modifier.align(Alignment.BottomCenter),

                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),



                onValueChange = { },
//                        newText ->
//
//                    viewModel.onQueryChange(newText)

                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = bebasNeueFamily,
                    fontWeight = FontWeight.Normal,
                    color = Peach,
                    ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(BlackBean2)
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        innerTextField()
                    }
                }
            )
        }


        Spacer(modifier = Modifier.height(36.dp))




        Box(modifier = Modifier
            .padding(22.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(110.dp)
            .background(color = ChocolateCosmos),
        ){

            Text(text = "Page: ",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
                color = Peach,
                fontFamily = bebasNeueFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )

            BasicTextField(
                value = page,
                modifier = Modifier.align(Alignment.BottomCenter),

                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = { newText -> page = newText },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = bebasNeueFamily,
                    fontWeight = FontWeight.Normal,
                    color = Peach,
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(BlackBean2)
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        innerTextField()
                    }
                }
            )
        }



        Spacer(modifier = Modifier.weight(1f))


        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Button(
                onClick = {
//                    viewModel.getData(query)
//                          navController.navigate(Screen.MainScreen.route)
                },
                modifier = Modifier
                    .padding(30.dp)
                    .height(50.dp)
                    .width(250.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Peach,
                    contentColor = BlackBean1
                )
            )
            {

                Text(text = "Apply",
                    fontFamily = bebasNeueFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp)
            }
        }




    }
}