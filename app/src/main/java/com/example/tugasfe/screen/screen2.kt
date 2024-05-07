package com.example.tugasfe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfe.component.imageId
import com.example.tugasfe.component.names

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen2(navController: NavHostController) {
    Scaffold (
        topBar ={
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Text(text = "screen2")
                }
            },
                navigationIcon = {
                    TextButton(onClick = { navController.navigate("screen1")}) {
                        Text(text = "back")
                    }
                },
                actions = {
                    TextButton(onClick = { navController.navigate("screen3")}) {
                        Text(text = "Next")
                    }
                }
            )
        }
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            val ItemCount = imageId.size
            items(ItemCount){item ->
                lazyitem(
                    itemIndex = item,
                    painter = imageId,
                    tittle = names,
                    navController = navController

                )
            }
        }
    }


}
@Composable
fun lazyitem(itemIndex: Int,
             painter: Array<Int>,
             tittle: Array<String>,
             navController: NavHostController) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable {
            navController.navigate(route = "detail/$itemIndex")
        }
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(140.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = tittle[itemIndex],
                    fontSize = 24.sp
                )
            }
        }
    }

}
