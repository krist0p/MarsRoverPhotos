package com.example.marsroverphotos.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marsroverphotos.ui.theme.BlackBean1
import com.example.marsroverphotos.ui.theme.Peach
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreenTopAppBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    TopAppBar(
        modifier = Modifier
            .height(60.dp),
        backgroundColor = BlackBean1

    ) {
        Icon(
            Icons.Outlined.Menu,
            tint = Peach,
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(40.dp)
                .clickable
                {
                    scope.launch { scaffoldState.drawerState.open() }
                }

        )
    }
}