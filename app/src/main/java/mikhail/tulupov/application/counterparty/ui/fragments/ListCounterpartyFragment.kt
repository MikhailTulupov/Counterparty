package mikhail.tulupov.application.counterparty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.databinding.FragmentListCounterpartyBinding
import mikhail.tulupov.application.counterparty.ui.adapters.ListCounterpartyAdapter
import mikhail.tulupov.application.counterparty.viewModels.ListViewModel


class ListCounterpartyFragment : Fragment() {

    lateinit var binding: FragmentListCounterpartyBinding
    private val viewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_list_counterparty,
                container,
                false
            )

        binding.apply {

            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ListCounterpartyAdapter {
                    findNavController().navigate(
                        ListCounterpartyFragmentDirections
                            .actionListCounterpartyFragmentToDetailCounterpartyFragment
                                (false, it.id)
                    )
                }
            }

            fab.setOnClickListener {
                val action =
                    ListCounterpartyFragmentDirections
                        .actionListCounterpartyFragmentToDetailCounterpartyFragment(
                            true,
                            null
                        )
                findNavController().navigate(action)
            }

        }

        viewModel.allCounterparty.observe(viewLifecycleOwner) {
            it.let {
                (binding.recyclerView.adapter as ListCounterpartyAdapter)
                    .submitList(it.toMutableList())
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //hide action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        //show action bar
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

}