package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewFilesAdapter
import android.app.Activity
import android.content.Intent
import android.content.Intent.getIntent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.a706012110039.levelup.databinding.FragmentProjectFilesBinding
import kotlinx.android.synthetic.main.fragment_project_files.*


class ProjectFiles : Fragment(), CardListener {

    private lateinit var binding: FragmentProjectFilesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentProjectFilesBinding.inflate(layoutInflater)
        return binding.root
    }

    lateinit var u: Uri

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupRecycler()
        Log.d(" resolver", contentResolver.toString())

        binding.addFileFAB.setOnClickListener {

//            val deferredResult = GlobalScope.async {
//
//                val sd = async {buttonOpenFile()
//                    Log.d("U",u.toString())
//
//                }.await()
//                val one = async {if(u!= null){            geturiData(u)
//                } }.await()
            buttonOpenFile()

//            Thread.sleep(5000)  // wait for 5 second
//            geturiData(u)

        }


        var amin = intent.getStringExtra("dataaa")
        var contentResolver = activity?.applicationContext?.contentResolver
//    }
    }



    fun setupRecycler() {

        projectfilesrv.layoutManager = GridLayoutManager(context, 3)
        projectfilesrv.adapter = GlobalVar.projects[GlobalVar.projects.size - 1].files?.let {
            RecyclerViewFilesAdapter(it, this)
        }
    }

    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }

    fun buttonOpenFile() {
        var chooseFile = Intent(Intent.ACTION_GET_CONTENT)
        chooseFile.type = "*/*"
        chooseFile = Intent.createChooser(chooseFile, "Choose a file")
        startActivityForResult(chooseFile, 1)
    }


    //get file data
    override fun onActivityResult(
        requestCode: Int, resultCode: Int, resultData: Intent?,
    ) {
        if (requestCode == 1
            && resultCode == Activity.RESULT_OK
        ) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            resultData?.data?.also { uri ->
                val filePath: String? = uri.path

                Toast.makeText(activity, filePath,
                    Toast.LENGTH_LONG).show()

                if (filePath != null) {
                    Log.d("Picfile", filePath)
                }
                u = uri
            }
        }
        val Intentt = Intent(context, dontdelete::class.java).apply {
            putExtra("data", u)
        }

        startActivity(Intentt)
    }
}




