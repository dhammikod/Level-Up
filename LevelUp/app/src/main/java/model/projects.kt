package model

data class projects(
    var id:Int,
    var title: String,
    var logoproject: String,
    var overview: String,
    var notes: String?,
    var startdate: String,
    var neededprofession: ArrayList<String>,
    var discussion: ArrayList<discussion>,
    var tasks:ArrayList<task>,
    var enrolleduser:ArrayList<Int>,
    var creator: Int,
    var files: ArrayList<files>
)
