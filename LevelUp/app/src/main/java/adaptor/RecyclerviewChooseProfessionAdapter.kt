package adaptor

import Interface.CardListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.CardviewChooseProfessionBinding
import com.a706012110039.levelup.databinding.CardviewProfessionBinding
import model.profession


class RecyclerviewChooseProfessionAdapter(private val dataSet: ArrayList<profession>, val cardlistener: CardListener) :
    RecyclerView.Adapter<RecyclerviewChooseProfessionAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, val cardlistener: CardListener) :
        RecyclerView.ViewHolder(view) {
        val binding = CardviewChooseProfessionBinding.bind(itemView)

        fun setdata(profesi: profession,posisi : Int){
            binding.namaProfesi.text = profesi.nama
            binding.logoProfesi.setImageResource(profesi.logo)
            binding.cardviewlogoprofesi.setOnClickListener {
                cardlistener.onCardClick(posisi)
            }

            if(profesi.isselected){
                binding.cardviewcheck.alpha = 1f
                binding.imageView29.setImageResource(R.drawable.ic_baseline_check_24)
            }else{
                binding.cardviewcheck.alpha = 0f
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_choose_profession, viewGroup, false)

        return ViewHolder(view, cardlistener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setdata(dataSet[position],position)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
