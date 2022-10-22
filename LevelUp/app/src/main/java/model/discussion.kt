package model

data class discussion(
    val title: String,
    val description: String,
    val creator: user,
    val replies: ArrayList<reply>

){

}