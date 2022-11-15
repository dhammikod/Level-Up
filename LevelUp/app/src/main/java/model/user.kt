package model

data class user(
    var id:Int,
    var name: String,
    var Email: String,
    var statuspremium: String,
    var projectdone: Int,
    var filesuploaded: Int,
    var comments: Int,
    var profession: ArrayList<String>,
    var mycurprojects: ArrayList<Int>,
    var mypastprojects: ArrayList<Int>
)
