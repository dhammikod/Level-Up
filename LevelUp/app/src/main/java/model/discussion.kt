package model

data class discussion(
    val title: String,
    val description: String,
    val creator: Int,
    val replies: ArrayList<reply>

){

}