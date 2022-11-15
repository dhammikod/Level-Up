package model

import java.util.Date

data class task(
    val title: String,
    val description: String,
    val duedate: Date,
    val pic: Int,
    var status: String


){

}