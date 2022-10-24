package adaptor

import Interface.CardListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import model.user


class RecylcerViewProjectTeamsAdapter(private val dataSet: ArrayList<user>, val cardListener: CardListener) :
        RecyclerView.Adapter<RecylcerViewProjectTeamsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val teamname: TextView
        val teamrole: TextView

        init {
            // Define click listener for the ViewHolder's View.
            image = view.findViewById(R.id.imageView9)
            teamname= view.findViewById(R.id.teamnametv)
            teamrole= view.findViewById(R.id.teamroletv)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cardview_teams, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.teamname.text = dataSet[position].name
        viewHolder.teamrole.text = dataSet[position].profession[0]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
