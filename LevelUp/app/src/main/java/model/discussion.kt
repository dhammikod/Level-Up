package model

data class discussion(
    var title: String,
    var description: String,
    var creator: Int,
    var replies: ArrayList<reply>

){

}