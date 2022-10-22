package model

data class user(
    val name: String,
    val Email: String,
    val statuspremium: String,
    val projectdone: Int,
    val filesuploaded: Int,
    val comments: Int,
    val profession: ArrayList<String>,
    val mycurprojects: ArrayList<projects>,
    val mypastprojects: ArrayList<projects>
)
