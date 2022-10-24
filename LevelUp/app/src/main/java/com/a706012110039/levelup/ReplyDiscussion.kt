package com.a706012110039.levelup

import Database.GlobalVar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.a706012110039.levelup.databinding.ActivityReplyDiscussionBinding
import kotlinx.android.synthetic.main.cardview_discussions.*

class ReplyDiscussion : AppCompatActivity() {
    private lateinit var binding:ActivityReplyDiscussionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReplyDiscussionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GetIntent()
    }

    private fun GetIntent(){
        val position = intent.getIntExtra("position",0)
        binding.discussiontitletva.text = GlobalVar.projects[GlobalVar.projects.size-1].discussion[position].title
        binding.disucussionmakertv.text = GlobalVar.users[GlobalVar.projects[GlobalVar.projects.size-1].discussion[position].creator].name
        binding.discussionrepdesctv.text = GlobalVar.projects[GlobalVar.projects.size-1].discussion[position].description
    }
}