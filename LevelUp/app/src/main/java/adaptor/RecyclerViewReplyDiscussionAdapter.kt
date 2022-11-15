package adaptor

import Database.GlobalVar
import Interface.CardListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewNewsBinding
import com.a706012110039.levelup.databinding.CardviewRepliesBinding
import model.discussion
import model.reply

class RecyclerViewReplyDiscussionAdapter (private val dataSet: ArrayList<reply>, val cardListener: CardListener) :
    RecyclerView.Adapter<RecyclerViewReplyDiscussionAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardviewRepliesBinding.bind(itemView)
        val message: TextView
        val pic: ImageView
        val userep: TextView

        init {
            // Define click listener for the ViewHolder's View.
            userep = view.findViewById(R.id.userreplytv)
            message = view.findViewById(R.id.replymesssagetv)
            pic = view.findViewById(R.id.replyppiv)

            }
    fun hideothers(){

        binding.cardView4.isVisible = false
        binding.replyppiv.isVisible=false
    }

        fun hideuser(){
            binding.userreplycv.isVisible = false
            binding.userreplytv.isVisible = false
        }


    }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cardview_replies, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element

            if(dataSet[position].user == GlobalVar.curuser){
                viewHolder.hideothers()
//                viewHolder.hideuser()
                viewHolder.pic.isVisible=false
                viewHolder.userep.text = dataSet[position].message
            }

            else{
                viewHolder.hideuser()
//                viewHolder.hideothers()
            viewHolder.message.text = dataSet[position].message

            }
//            viewHolder.pic.setImageURI(GlobalVar.users[dataSet[position].user].)

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size



}