package com.example.tugasfe.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun detail(photos:Array<Int>,
           name:Array<String>,
           ingridients:Array<String>,
           itemIndex:Int?,
           navController: NavHostController) {
 Column(modifier = Modifier
     .fillMaxSize()
     .padding(24.dp),
     verticalArrangement = Arrangement.spacedBy(24.dp),
     horizontalAlignment = Alignment.CenterHorizontally) {
     Box(modifier = Modifier.fillMaxWidth()
         ,Alignment.TopCenter){
         Image(painter = painterResource(id = photos[itemIndex!!]),
             contentDescription =name[itemIndex] )
     }
     Text(text = name[itemIndex!!],
         fontSize = 40.sp)
     Text(text = ingridients[itemIndex],
         fontSize = 20.sp)
     TextButton(onClick = { navController.navigate("screen1") }) {
         Text(text = "Back")

     }
     }
 }

