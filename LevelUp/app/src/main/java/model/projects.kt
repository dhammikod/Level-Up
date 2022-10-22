package model

data class projects(
    val id:Int,
    val title: String,
    val logoproject: String,
    val overview: String,
    val notes: String,
    val startdate: String,
    val neededprofession: ArrayList<String>,
    val discussion: ArrayList<discussion>,
    val tasks:ArrayList<task>,
    val enrolleduser:ArrayList<Int>
)
