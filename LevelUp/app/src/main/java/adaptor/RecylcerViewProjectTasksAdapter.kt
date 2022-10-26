package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewRecentprojectsBinding
import com.a706012110039.levelup.databinding.CardviewTasksBinding
import model.discussion
import model.projects
import model.task
import model.user


class RecylcerViewProjectTasksAdapter (private val data: ArrayList<task>, val cardListener: CardListener) :
    RecyclerView.Adapter<RecylcerViewProjectTasksAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView
        val desc: TextView
        val duedate: TextView
        val pic:TextView
        val status:CheckBox

        init {
            // Define click listener for the ViewHolder's View.
            title = view.findViewById(R.id.tasknametv)
            desc= view.findViewById(R.id.taskdetailtv)
            duedate= view.findViewById(R.id.taskduetv)
            pic = view.findViewById(R.id.taskpictv)
            status =  view.findViewById(R.id.taskcheck)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_tasks, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = data[position].title
        viewHolder.desc.text= data[position].description
        viewHolder.duedate.text=data[position].duedate.toString()

        if (data[position].status =="Y"){
            viewHolder.status.isChecked = true}

        else if (data[position].status =="N"){
            viewHolder.status.isChecked = false}

        viewHolder.pic.text ="Everyone"
    }



    override fun getItemCount() = data.size
}





