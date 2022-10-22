package adaptor

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewRecentprojectsBinding
import com.squareup.picasso.Picasso
import model.projects


class recyclerviewRecentsAdaptor(private val dataSet: ArrayList<projects>) :
        RecyclerView.Adapter<recyclerviewRecentsAdaptor.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewRecentprojectsBinding.bind(itemView)

        fun setdata(data: projects){
            if(!data.title.isNullOrBlank()){
                if(!data.logoproject.isNullOrBlank()){
                   binding.logoprojectimage.setImageURI(Uri.parse(data.logoproject))
                }
            }else{
                binding.logoprojectimage.setImageResource(R.drawable.ic_baseline_add_24)
            }
        }
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

        viewHolder.setdata(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
