package adaptor

import Interface.CardListener
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import model.files


class RecyclerViewFilesAdapter (private val dataSet: ArrayList<files>, val cardListener: CardListener) :
    RecyclerView.Adapter<RecyclerViewFilesAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView
        val image: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.filenametv)
            image = view.findViewById(R.id.fileiv)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_files, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].name

        if (dataSet[position].name != null)
            viewHolder.image.setImageResource(R.drawable.job_default)
        if (dataSet[position].name.contains("doc"))
            viewHolder.image.setImageResource(R.drawable.word)

        if (dataSet[position].name.contains("pptx"))
            viewHolder.image.setImageResource(R.drawable.ppt)

        if (dataSet[position].name.contains("pdf"))
            viewHolder.image.setImageResource(R.drawable.pdf)


        if (dataSet[position].name.contains("xls"))
            viewHolder.image.setImageResource(R.drawable.spreadsheet)



    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}



