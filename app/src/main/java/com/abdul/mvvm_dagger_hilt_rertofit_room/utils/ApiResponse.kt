package com.abdul.mvvm_dagger_hilt_rertofit_room.utils

sealed class ApiResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}

