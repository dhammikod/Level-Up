package Database

import model.projects
import model.user

class GlobalVar {
    companion object{
        val users = ArrayList<user>()
        val projects = ArrayList<projects>()
        val news = ArrayList<Int>()
    }
}