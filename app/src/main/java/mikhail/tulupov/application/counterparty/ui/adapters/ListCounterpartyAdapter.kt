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

class ListCounterpartyAdapter(onclick: () -> Unit) :
    ListAdapter<Counterparty, ListCounterpartyViewHolder>(CounterpartyDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCounterpartyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemCounterpartyBinding>(
            inflater,
            R.layout.list_item_counterparty, parent, false
        )

        return ListCounterpartyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ListCounterpartyViewHolder, position: Int) {
        val counterparty = getItem(position)
        val binding = holder.binding

        binding?.ivAvatar?.setImageBitmap(counterparty.avatar)
        binding?.tvName?.text = SpannableStringBuilder(counterparty.name)
    }

}

class ListCounterpartyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ListItemCounterpartyBinding? = DataBindingUtil.bind(itemView)
}

class CounterpartyDiffCallback : DiffUtil.ItemCallback<Counterparty>() {
    override fun areItemsTheSame(oldItem: Counterparty, newItem: Counterparty): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Counterparty, newItem: Counterparty): Boolean =
        oldItem == newItem
}