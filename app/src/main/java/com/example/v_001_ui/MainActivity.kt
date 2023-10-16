package com.example.v_001_ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.v_001_ui.composable.makeProfile
import com.example.v_001_ui.presentation.screen.HomeScreen
import com.example.v_001_ui.ui.theme.V_001_uiTheme
import com.example.v_001_ui.view_model.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.v_001_ui.data.vos.PostVo
import com.example.v_001_ui.service.ApiState
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postViewModel : PostViewModel by viewModels()
        var data : String = "empty"
        lifecycleScope.launch {

            postViewModel.postResult.collect{
                when (it) {

                    is ApiState.Loading -> {

                        data = "Loading"
                    }
                    is ApiState.Success -> {

                        data = "Success ${it.data}"
                    }
                    is ApiState.Success -> {

                        data = "Fail $it."
                    }
                    else -> {

                        data = "Unknow State $it"
                    }
                }
            }
        }
        setContent {
            V_001_uiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                //   HomeScreen()

                    Greeting(name = "hello")
                //    Text("${data}")

                }
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun Greeting(


    name: String, modifier: Modifier = Modifier) {

    val postViewModel: PostViewModel = hiltViewModel()

    val myData by postViewModel.composeState.collectAsState()

    Box{
     when(myData){

         is ApiState.Loading -> {
             Box(
                 contentAlignment = Alignment.Center,
                 modifier = Modifier.fillMaxSize()
             ) {
                 CircularProgressIndicator()
             }
         }
         is ApiState.Failure -> {
             Text(text = "${myData.message}")
         }
         is ApiState.Success -> {
             LazyColumn{
                 items((myData.data?: emptyList()).size){ position ->

                     Card(

                         modifier = Modifier.fillMaxWidth()
                             .padding(8.dp)

                     ) {
                         Text(
                             modifier= Modifier.padding(8.dp),
                             text = myData.data?.get(position)?.title?:"")
                     }
                 }
             }
         }
         else ->  {
             CircularProgressIndicator()
         }
     }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(

) {
    V_001_uiTheme {
        Greeting("Android")
    }
}