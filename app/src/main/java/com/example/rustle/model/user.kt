package com.example.rustle.model

data class user(var username:String=""){
        var email=""
        var phone=""
        var grade=""
        var major=""
        var photourl=""


}
enum class Grade {
    FRESHMAN,SOPHOMORE,JUNIOR,SERNIOR,OTHER
}