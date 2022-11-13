package adaptor

import Database.GlobalVar
import android.content.Context
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewJobsforyouBinding
import model.projects


class RecyclerViewJobsForYouAdapter(private val dataSet: ArrayList<projects>) :
    RecyclerView.Adapter<RecyclerViewJobsForYouAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewJobsforyouBinding.bind(itemView)

        fun setdata(data: projects){
            val context: Context = binding.imageView18.getContext()
            val id: Int = context.getResources()
                .getIdentifier(data.logoproject, "drawable", context.getPackageName())
            binding.imageView18.setImageResource(id)
            binding.titleJOBSFORU.text = data.title
            Log.d("HERE", GlobalVar.users.toString())
            binding.creatorJOBSFORU.text = GlobalVar.users.get(data.creator).name

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_jobsforyou, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setdata(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
