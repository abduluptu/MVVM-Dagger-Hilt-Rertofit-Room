package com.abdul.mvvm_dagger_hilt_rertofit_room.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.abdul.mvvm_dagger_hilt_rertofit_room.ui.theme.MVVMDaggerHiltRertofitRoomTheme
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.ApiResponse
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.Constants.TAG
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.Util
import com.abdul.mvvm_dagger_hilt_rertofit_room.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

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

                    //loading state
                    /* MainScreen(isLoading) {
                         // Callback to update isLoading

                     }*/

                    /* viewModel.productsLiveData.observe(this, Observer {
                         //products.text =  it.joinToString { x -> x.title + "\n\n" }
                         data = it
                         Log.d("SOHA", data.toString())
                     })*/

                    viewModel.products.observe(this, Observer { response ->

                        when (response) {
                            is ApiResponse.Success -> {
                                // Handle success, update UI with response.data
                                val data = response.data
                                Log.d(TAG, "Result: " + data.toString())
                            }

                            is ApiResponse.Error -> {
                                // Handle error, show error message (response.errorMessage)
                                val errorMessage = response.errorMessage
                                Log.d(TAG, "Error: " + errorMessage)
                                if (errorMessage.isNotBlank()) {
                                    // Show error dialog or toast with errorMessage
                                    Util.showDialog(this, errorMessage)
                                }
                            }

                            ApiResponse.Loading -> {
                                // Show a loading indicator
                                Log.d(TAG, "Loading")
                            }
                        }
                    })


                    viewModel.isLoading.observe(this, Observer { isLoading ->
                        // Update UI based on isLoading state (e.g., show/hide loading indicator)

                        if (isLoading) {
                            // Show loading indicator

                        } else {
                            // Hide loading indicator
                        }
                    })

                    // Call your ViewModel function to fetch data
                    viewModel.fetchProducts()
                }
            }
            //
        }
    }
}

@Composable
fun getProducts() {

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


