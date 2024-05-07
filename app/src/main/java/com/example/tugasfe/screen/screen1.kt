package com.example.tugasfe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfe.component.imageId
import com.example.tugasfe.component.names

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen1(navController: NavHostController) {
    Scaffold (
        topBar ={
            TopAppBar(title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        Text(text = "screen1")
                    }
                },
                actions = {
                    TextButton(onClick = { navController.navigate("screen2")}) {
                        Text(text = "Next")
                    }
                }
            )
        }
    ){
        Column (modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()){
            val ItemCount = imageId.size
            LazyRow(contentPadding = PaddingValues(16.dp)) {
                items(ItemCount){item ->
                    RowItem(
                        itemIndex = item,
                        painter = imageId,
                        navController = navController
                    )
                }
            }
            LazyColumn(contentPadding = PaddingValues(16.dp))
            {
                items(ItemCount){item ->
                    ColumnItem(
                        itemIndex = item,
                        painter = imageId,
                        tittle = names,
                        navController = navController

                    )
                }
            }
        }
    }
}

@Composable
fun RowItem(
    itemIndex: Int,
    painter: Array<Int>,
    navController: NavHostController) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)){
    }
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        Image(painter = painterResource(id = painter[itemIndex]),
            contentDescription ="",
            modifier = Modifier.size(140.dp)
                .clickable {
                    navController.navigate(route = "detail/$itemIndex")
                })
    }

}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    navController: NavHostController
){
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable {
            navController.navigate(route = "detail/$itemIndex")
        }
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp))
    {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription =tittle[itemIndex],
                modifier = Modifier.size(140.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = tittle[itemIndex],
                    fontSize = 24.sp)
            }

        }

    }
}


