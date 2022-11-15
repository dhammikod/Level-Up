package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewJobsforyouBinding
import model.projects
import java.util.*
import kotlin.collections.ArrayList
import android.widget.Filter
import com.a706012110039.levelup.databinding.CardviewProjectsPastBinding


class RecyclerView_Projects_Past(private val dataSet: ArrayList<projects>, val cardListener: CardListener) :
    RecyclerView.Adapter<RecyclerView_Projects_Past.ViewHolder>() {
    val initialProjectsDataList = ArrayList<projects>().apply {
        dataSet?.let { addAll(it) }
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, val cardListener: CardListener) : RecyclerView.ViewHolder(view) {
        val binding = CardviewProjectsPastBinding.bind(itemView)

        fun setdata(data: projects){
            val context: Context = binding.cvProjectPastImageView.context
            val id: Int = context.resources.getIdentifier(data.logoproject, "drawable", context.packageName)
            binding.cvProjectPastImageView.setImageResource(id)
            binding.cvProjectPastTitle.text = data.title
            Log.d("HERE", GlobalVar.users.toString())
            binding.cvProjectPastCreator.text = "by " + GlobalVar.users[data.creator].name

            binding.cvProjectPastCollaborators.text = data.enrolleduser.toString()

            itemView.setOnClickListener {
                cardListener.onCardClick(adapterPosition)
            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_projects_past, viewGroup, false)
        return ViewHolder(view, cardListener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setdata(dataSet[position])


    }

    fun getFilter():  Filter {
        return filter
    }

    private val filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<projects> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                initialProjectsDataList.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().lowercase(Locale.ROOT)
                initialProjectsDataList.forEach {
                    if (it.title.lowercase(Locale.ROOT).contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                dataSet.clear()
                dataSet.addAll(results.values as ArrayList<projects>)
                notifyDataSetChanged()
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
