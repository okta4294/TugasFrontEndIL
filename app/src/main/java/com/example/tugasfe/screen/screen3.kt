package com.example.tugasfe.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfe.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen3(navController: NavHostController) {
    Scaffold (
        topBar ={
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Text(text = "About Me")
                }
            },
                navigationIcon = {
                    TextButton(onClick = { navController.navigate("screen2")}) {
                        Text(text = "back")
                    }
                }
            )
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth(),
            Alignment.TopCenter){
            Image(painter = painterResource(id = R.drawable.fotoku),
                contentDescription ="foto",
                modifier = Modifier.size(400.dp))
        }
        Text(text = "Nama : Fachrudin Okta Rahmawan",
            fontSize = 20.sp)

            Text(text = "Email : fachrudinokta@gmail.com",
                fontSize = 20.sp)
            Text(text = "Perguruan : Universitas Amikom Yogyakarta",
                fontSize = 20.sp,
                textAlign = TextAlign.Center)
            Text(text = "Jurusan : S1 Informatika",
                fontSize = 20.sp)

        }

    }
}