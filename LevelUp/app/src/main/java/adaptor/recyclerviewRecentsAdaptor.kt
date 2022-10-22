package adaptor

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewRecentprojectsBinding
import model.projects


class recyclerviewRecentsAdaptor(private val dataSet: ArrayList<projects>) :
        RecyclerView.Adapter<recyclerviewRecentsAdaptor.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewRecentprojectsBinding.bind(itemView)
        var img : ImageView

        init{
            img = view.findViewById(R.id.logoprojectimage)
        }

//        fun setdata(data: Result){
//            binding.tvTitleNowPlaying.text = data.title
//            binding.tvReleased.text = data.release_date
//            binding.cvNowplaying.setOnClickListener {
//                val intent = Intent(it.context, Activity_Movie_Detail::class.java).putExtra("movieid",data.id)
//                it.context.startActivity(intent)
//            }
//        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cardview_recentprojects, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if(!dataSet[position].title.isNullOrBlank()){
            if(!dataSet[position].logoproject.isNullOrBlank()){
                viewHolder.img.setImageURI(Uri.parse(dataSet[position].logoproject))
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
