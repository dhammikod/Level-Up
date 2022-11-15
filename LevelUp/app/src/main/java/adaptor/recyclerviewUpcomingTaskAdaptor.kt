package adaptor

import Database.GlobalVar
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewRecentprojectsBinding
import com.a706012110039.levelup.databinding.CardviewUpcomingtaskBinding
import model.projects


class recyclerviewUpcomingTaskAdaptor(private val dataSet: ArrayList<String>) :
        RecyclerView.Adapter<recyclerviewUpcomingTaskAdaptor.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewUpcomingtaskBinding.bind(itemView)

        fun setdata(pos: String){
            binding.upcomingtaskTextview.text = pos
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cardview_upcomingtask, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.setdata(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
