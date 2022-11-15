package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewRecentprojectsBinding
import model.projects

class recyclerviewRecentsAdaptor(private val dataSet: ArrayList<Int>, val cardListener: CardListener) :
        RecyclerView.Adapter<recyclerviewRecentsAdaptor.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewRecentprojectsBinding.bind(itemView)

        fun setdata(indexproyek: Int, cardListener: CardListener){
            var data : projects
            data = GlobalVar.projects[0]
            for (i in 0..GlobalVar.projects.size-1){
                if(GlobalVar.projects[i].id == indexproyek){
                    data = GlobalVar.projects[i]
                }
            }

            if(indexproyek == -1){
                binding.logoprojectimage.setImageResource(R.drawable.ic_baseline_add_black)
            }else if(!data.logoproject.isNullOrBlank()){

                binding.logoprojectimage.setImageURI(Uri.parse(data.logoproject))
                val context: Context = binding.logoprojectimage.getContext()
                val id: Int = context.getResources()
                    .getIdentifier(data.logoproject, "drawable", context.getPackageName())
                binding.logoprojectimage.setImageResource(id)
            }

            binding.logoprojectimage.setOnClickListener(){
                cardListener.onCardClick(position)
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

        viewHolder.setdata(dataSet[position],cardListener)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
