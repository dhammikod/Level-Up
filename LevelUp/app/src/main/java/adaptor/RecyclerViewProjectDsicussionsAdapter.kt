package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.ProjectActivity
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewDiscussionsBinding
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
            val replybutton:Button
            val img1: ImageView
            val img2: ImageView
            val replytext: TextView

            init {
                // Define click listener for the ViewHolder's View.
                title = view.findViewById(R.id.discussiontitletv)
                desc= view.findViewById(R.id.discussiondesctv)
                creator= view.findViewById(R.id.discussioncreatortv)
                reply1 = view.findViewById(R.id.replyincardtv1)
                reply2 = view.findViewById(R.id.replyincardtv2)
                replybutton =  view.findViewById(R.id.replydiscussionbutton)
                img1 = view.findViewById(R.id.imageView10)
                img2 = view.findViewById(R.id.imageView11)
                replytext = view.findViewById(R.id.textView15)
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
            viewHolder.reply1.text = dataSet[position].replies[0].message
                viewHolder.reply2.isVisible = false
                viewHolder.img2.isVisible = false
            }
             else if(dataSet[position].replies.size<1) {
                 viewHolder.replytext.isVisible=false
                viewHolder.reply2.isVisible = false
                viewHolder.reply1.isVisible = false
                viewHolder.img1.isVisible = false
                viewHolder.img2.isVisible = false
            }

        viewHolder.replybutton.setOnClickListener(){
           cardListener.onCardClick(position)
        }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size



}