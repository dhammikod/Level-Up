package Database

import model.projects
import model.user

class GlobalVar {
    companion object{
        val users = ArrayList<user>()
        val projects = ArrayList<projects>()
        var curuser = 0
        var upcomingTask = ArrayList<String>()
        var tempDATAFILE = ""
    }
}