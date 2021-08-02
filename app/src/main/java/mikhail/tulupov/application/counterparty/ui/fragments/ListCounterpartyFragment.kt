package mikhail.tulupov.application.counterparty.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.databinding.FragmentListCounterpartyBinding


class ListCounterpartyFragment : Fragment() {

    private lateinit var binding: FragmentListCounterpartyBinding

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



        return binding.root
    }

}