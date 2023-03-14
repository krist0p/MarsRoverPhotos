package com.example.marsroverphotos.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marsroverphotos.presentation.main_screen.MainScreenViewModel
import com.example.marsroverphotos.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreenDrawer(
//    viewModel: MainScreenViewModel
      queryValue: String,
      changeQuery: (String) -> Unit,
      getData: () -> Unit,
      scope: CoroutineScope,
      scaffoldState: ScaffoldState,



){
    val keyboardController = LocalSoftwareKeyboardController.current


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
            .height(150.dp)
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
            Text(text = "(A value in a range from 1000 to 3000)",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(16.dp),
                color = Peach,
                fontFamily = bebasNeueFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp

            )

            BasicTextField(
                value = queryValue,
                modifier = Modifier.align(Alignment.BottomCenter),

                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),



                onValueChange = { newText ->
                    changeQuery(newText)
                },


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
                    getData()
                    scope.launch { scaffoldState.drawerState.close()}
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