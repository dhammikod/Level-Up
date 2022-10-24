package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import model.discussion

class RecyclerViewProjectDsicussionsAdapter (private val dataSet: ArrayList<discussion>, val cardListener: CardListener) :
        RecyclerView.Adapter<RecyclerViewProjectDsicussionsAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView
            val desc: TextView
            val creator: TextView
            val reply1:TextView
            val reply2:TextView

            init {
                // Define click listener for the ViewHolder's View.
                title = view.findViewById(R.id.discussiontitletv)
                desc= view.findViewById(R.id.discussiondesctv)
                creator= view.findViewById(R.id.discussioncreatortv)
                reply1 = view.findViewById(R.id.replyincardtv1)
                reply2 = view.findViewById(R.id.replyincardtv2)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cardview_discussions, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.title.text = dataSet[position].title
            viewHolder.desc.text = dataSet[position].description
            viewHolder.creator.text = GlobalVar.users[dataSet[position].creator].name

            if (dataSet[position].replies.size>1){
                viewHolder.reply1.text = dataSet[position].replies[0].message
                viewHolder.reply2.text = dataSet[position].replies[1].message
            }

            else if (dataSet[position].replies.size==1){
            viewHolder.reply1.text = dataSet[position].replies[0].toString()
                viewHolder.reply2.isVisible = false
            }
             else if(dataSet[position].replies.size<1) {
                viewHolder.reply2.isVisible = false
                viewHolder.reply1.isVisible = false
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size



}