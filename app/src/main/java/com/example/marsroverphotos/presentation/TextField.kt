//package com.example.marsroverphotos.presentation
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.marsroverphotos.ui.theme.BlackBean2
//import com.example.marsroverphotos.ui.theme.Peach
//import com.example.marsroverphotos.ui.theme.bebasNeueFamily
//
//@Composable
//fun TextField(text: String, value: MutableState<String>){
//
//
//
//
//
//    Text(text = "Martian date (Sol): ",
//        modifier = Modifier
//            .align(Alignment.TopStart)
//            .padding(16.dp),
//        color = Peach,
//        fontFamily = bebasNeueFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 20.sp
//
//    )
//
//    var sol by remember { mutableStateOf(TextFieldValue("")) }
//
//
//
//
//    BasicTextField(
//        value = sol,
//        modifier = Modifier.align(Alignment.BottomCenter),
//
//        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//        onValueChange = { newText ->
//            sol = newText
//        }
//        ,  textStyle = TextStyle(
//            fontSize = 20.sp,
//            fontFamily = bebasNeueFamily,
//            fontWeight = FontWeight.Normal,
//            color = Peach,
//        ),
//        decorationBox = { innerTextField ->
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//                    .height(40.dp)
//                    .clip(RoundedCornerShape(10.dp))
//                    .background(BlackBean2)
//                    .padding(10.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                innerTextField()
//            }
//        }
//    )
//}
//
//
//
