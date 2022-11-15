package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewNewsAdaptor
import adaptor.recyclerviewRecentsAdaptor
import adaptor.recyclerviewUpcomingTaskAdaptor
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel
import model.projects
import model.user
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.fragment_home.*
import model.news

class HomeFragment : Fragment(), CardListener {
    private lateinit var viewbind: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewbind = FragmentHomeBinding.inflate(layoutInflater)
        adddummydatarecents()
        upcomingtask()
        tesads()
        tesnews()
        piechart()

        return viewbind.root
    }

    fun tesnews(){
        var listnews : ArrayList<news>
        listnews = ArrayList()
        listnews.add(news("Plastico Corp, a recyling project turned business","BBC News","news_pic_1"))
        listnews.add(news("Animator, Combining puppets and animaton bringing back nostalgia","Shaun Whitore","news_pic_2"))
        listnews.add(news("Foodste, Leftover food as potential to start a business","BBC News","news_pic_3"))

        val newsAdaptor: RecyclerViewNewsAdaptor
        newsAdaptor = RecyclerViewNewsAdaptor(listnews)
        viewbind.recyclerviewnews.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.recyclerviewnews.adapter = newsAdaptor
    }

    fun piechart(){
        var pieChart = viewbind.pieChart

        // on below line we are setting user percent value,
        // setting description as enabled and offset for pie chart
        pieChart.setUsePercentValues(true)
        pieChart.getDescription().setEnabled(false)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
        pieChart.setDrawHoleEnabled(true)
        pieChart.setHoleColor(Color.WHITE)

        // on below line we are setting circle color and alpha
        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        pieChart.setHoleRadius(58f)
        pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
        pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
        pieChart.setRotationAngle(0f)

        // enable rotation of the pieChart by touch
        pieChart.setRotationEnabled(true)
        pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        pieChart.legend.isEnabled = false
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(12f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(60f))
        entries.add(PieEntry(40f))


        // on below line we are setting pie data set
        val dataSet = PieDataSet(entries, "Mobile OS")

        // on below line we are setting icons.
        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors to list
        val colors: ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.lightbluebg))
        colors.add(resources.getColor(R.color.purple_200))

        dataSet.colors = colors

        // on below line we are setting pie data set
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        pieChart.setData(data)

        // undo all highlights
        pieChart.highlightValues(null)

        // loading chart
        pieChart.invalidate()
    }

    fun tesads(){
        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel(R.drawable.news1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news3, ScaleTypes.FIT))

        viewbind.carouselnews.setImageList(imageList)
    }

    fun upcomingtask() {
        var temp: ArrayList<String>
        temp = ArrayList()
        var tempINT = 0
        for (i in GlobalVar.projects) {
            var temppppp = 0
            for (x in GlobalVar.projects[tempINT].tasks) {
                if (GlobalVar.projects[tempINT].tasks[temppppp].status == "N") {
                    temp.add(GlobalVar.projects[tempINT].tasks[temppppp].title)
                }
                temppppp++

            }
            tempINT++
        }

        Log.d("here",temp.toString())

            val upcomingAdaptor: recyclerviewUpcomingTaskAdaptor
            upcomingAdaptor = recyclerviewUpcomingTaskAdaptor(temp)
            viewbind.UpcomingtaskRV.layoutManager =
                LinearLayoutManager(requireActivity().baseContext,
                    LinearLayoutManager.VERTICAL,
                    false)
            viewbind.UpcomingtaskRV.adapter = upcomingAdaptor

    }

    fun adddummydatarecents(){

        var idproject = 0

        if  (GlobalVar.projects.size<1){
        for(i in 0..5){
            if (GlobalVar.users.size > 0){
                idproject = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.projects.add(projects(idproject,"title","cilukba","lorem50","penting","oktober", arrayListOf(),
                arrayListOf(), arrayListOf(), arrayListOf(),1,
                arrayListOf()))
        }
            GlobalVar.users[GlobalVar.curuser].mycurprojects.add(0)

        }
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        if(GlobalVar.users[GlobalVar.curuser].mycurprojects.size < 3 && !GlobalVar.users[GlobalVar.curuser].mycurprojects.contains(-1)){
            GlobalVar.users[GlobalVar.curuser].mycurprojects.add(-1)
        }else if(GlobalVar.users[GlobalVar.curuser].mycurprojects.size > 3 && GlobalVar.users[GlobalVar.curuser].mycurprojects.contains(-1)){
            GlobalVar.users[GlobalVar.curuser].mycurprojects.remove(-1)
        }

        val recentsAdaptor: recyclerviewRecentsAdaptor
        recentsAdaptor = recyclerviewRecentsAdaptor(GlobalVar.users[GlobalVar.curuser].mycurprojects, this )
        viewbind.RVrecentprojects.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.RVrecentprojects.adapter = recentsAdaptor
    }

    override fun onCardClick(position: Int) {
        val Intent = Intent(activity, ProjectActivity::class.java)
        GlobalVar.curproject=position
        startActivity(Intent)
    }
}