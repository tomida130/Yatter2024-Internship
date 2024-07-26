package com.dmm.bootcamp.yatter2024.ui.register

data class RegisterAccountUiState(
    val bindingModel: RegisterAccountModel,
    val isLoading: Boolean,
){
    companion object{
        fun empty(): RegisterAccountUiState = RegisterAccountUiState(

            bindingModel = RegisterAccountModel(
                username = "",
                password = ""
            ),
            isLoading = false,

        )
    }
}