package model

data class user(
    val id:Int,
    val name: String,
    val Email: String,
    val statuspremium: String,
    val projectdone: Int,
    val filesuploaded: Int,
    val comments: Int,
    val profession: ArrayList<String>,
    val mycurprojects: ArrayList<Int>,
    val mypastprojects: ArrayList<Int>,
    val profilepic: String
)
