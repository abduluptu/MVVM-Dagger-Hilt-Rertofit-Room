package com.abdul.mvvm_dagger_hilt_rertofit_room.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import com.abdul.mvvm_dagger_hilt_rertofit_room.ui.theme.MVVMDaggerHiltRertofitRoomTheme
import com.abdul.mvvm_dagger_hilt_rertofit_room.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var viewModel: ProductViewModel

    lateinit var data: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMDaggerHiltRertofitRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Greeting("Android")

                    viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

                    viewModel.productsLiveData.observe(this, Observer {
                        //products.text =  it.joinToString { x -> x.title + "\n\n" }
                        data = it
                        Log.d("SOHA", data.toString())
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMDaggerHiltRertofitRoomTheme {
        Greeting("Android")
    }
}