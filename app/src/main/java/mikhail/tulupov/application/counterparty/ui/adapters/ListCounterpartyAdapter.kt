package mikhail.tulupov.application.counterparty.ui.adapters

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.databinding.ListItemCounterpartyBinding
import mikhail.tulupov.application.counterparty.ui.adapters.ListCounterpartyAdapter.ListCounterpartyViewHolder

class ListCounterpartyAdapter(private val onClickListener: (Counterparty) -> Unit) :
    ListAdapter<Counterparty, ListCounterpartyViewHolder>(
        COUNTERPARTY_COMPARATOR) {

    // override this fun for sort list
    override fun submitList(list: MutableList<Counterparty>?) {
        super.submitList(list)
        list?.sortBy { it.name.lowercase() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCounterpartyViewHolder {
        return ListCounterpartyViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: ListCounterpartyViewHolder, position: Int) {
        val counterparty = getItem(position)
        holder.bind(counterparty, onClickListener)
    }

    class ListCounterpartyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ListItemCounterpartyBinding? = DataBindingUtil.bind(itemView)

        // binding data and layout
        fun bind(counterparty: Counterparty, onClickListener: (Counterparty) -> Unit) {
            binding?.apply {
                ivAvatar.setImageBitmap(counterparty.avatar)
                tvName.text = SpannableStringBuilder(counterparty.name)
                root.setOnClickListener { onClickListener(counterparty) }
            }
        }

        companion object {
            // this fun pre-pair view holder and return view holder
            fun onCreate(parent: ViewGroup): ListCounterpartyViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ListItemCounterpartyBinding>(
                    inflater,
                    R.layout.list_item_counterparty, parent, false
                )
                return ListCounterpartyViewHolder(binding.root)
            }
        }
    }

    companion object {
        //  calculate the difference between two lists and output a list of update operations
        //  that converts the first list into the second one.
        private  val COUNTERPARTY_COMPARATOR = object : DiffUtil.ItemCallback<Counterparty>() {
            override fun areItemsTheSame(oldItem: Counterparty, newItem: Counterparty): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Counterparty, newItem: Counterparty): Boolean =
                oldItem == newItem
        }
    }
}