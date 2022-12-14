package com.a706012110039.levelup

import Database.GlobalVar
import Database.GlobalVar.Companion.curproject
import Interface.CardListener
import adaptor.RecyclerViewProjectDsicussionsAdapter
import adaptor.RecyclerViewReplyDiscussionAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.a706012110039.levelup.databinding.ActivityReplyDiscussionBinding
import kotlinx.android.synthetic.main.activity_reply_discussion.*
import kotlinx.android.synthetic.main.cardview_discussions.*
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*
import model.reply

class ReplyDiscussion : AppCompatActivity(), CardListener {
    private  var position=0
    private var adapter= RecyclerViewReplyDiscussionAdapter(GlobalVar.projects[curproject].discussion[position].replies,this)
    private lateinit var binding:ActivityReplyDiscussionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReplyDiscussionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GetIntent()
        setupRecycler()
        listener()
    }

    private fun GetIntent(){
        position = intent.getIntExtra("position",0)
        binding.discussiontitletva.text = GlobalVar.projects[curproject].discussion[position].title
        binding.disucussionmakertv.text = GlobalVar.users[GlobalVar.projects[curproject].discussion[position].creator].name
        binding.discussionrepdesctv.text = GlobalVar.projects[curproject].discussion[position].description
    }
    private fun listener(){
        binding.imageView12.setOnClickListener(){
            this.finish()
        }

        binding.sendreply.setOnClickListener(){

          var replymessage = replyinputtext.text.toString()

            if (replymessage!= "") {
                GlobalVar.projects[curproject].discussion[position].replies.add(
                    reply(0, replymessage)
                )
                adapter.notifyDataSetChanged()
                replyinputtext.text = null
                super.onResume()
            }
            else{}




            }



    }
    fun setupRecycler(){
        adapter= RecyclerViewReplyDiscussionAdapter(GlobalVar.projects[curproject].discussion[position].replies,this)
       val layoutManager = GridLayoutManager(baseContext, 1)
        repliesrv.layoutManager = layoutManager
        repliesrv.adapter = adapter
    }

    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }
}