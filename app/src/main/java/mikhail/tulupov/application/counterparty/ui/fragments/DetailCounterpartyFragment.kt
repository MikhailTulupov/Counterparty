package mikhail.tulupov.application.counterparty.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import de.hdodenhof.circleimageview.CircleImageView
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.data.models.Counterparty.CounterpartyFactory
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.databinding.FragmentDetailCounterpartyBinding
import mikhail.tulupov.application.counterparty.utilities.Utils.setDefaultAvatar
import mikhail.tulupov.application.counterparty.viewModels.DetailViewModels
import java.util.*

class DetailCounterpartyFragment : Fragment() {

    private lateinit var binding: FragmentDetailCounterpartyBinding
    private val detailViewModel by viewModels<DetailViewModels>()
    private var isEditMode: Boolean = false
    private var id: UUID? = null
    private val selectImageFromGalleryResult = activityResultLauncher()
    private lateinit var avatar: CircleImageView
    private lateinit var counterparty: Counterparty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val safeArgs: DetailCounterpartyFragmentArgs by navArgs()
        isEditMode = safeArgs.isEdit

        id = safeArgs.id
        if (id == null) {
            counterparty = CounterpartyFactory.makeCounterparty(setDefaultAvatar(context))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail_counterparty, container, false
        )

        setHasOptionsMenu(true)

        avatar = binding.circleImageView

        if (id != null) {
            detailViewModel.getCounterpartyById(id!!).observe(viewLifecycleOwner) {
                it.let {
                    counterparty = it
                    binding.counterparty = it
                }
            }
        }

        if (isEditMode)
            showCurrentMode(isEditMode)

        binding.fab.setOnClickListener {
            if (isEditMode)
                saveProfileInfo()
            isEditMode = !isEditMode
            showCurrentMode(isEditMode)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_delete -> {
                detailViewModel.deleteCounterparty(counterparty)
                val action = DetailCounterpartyFragmentDirections
                    .actionDetailCounterpartyFragmentToListCounterpartyFragment()
                findNavController().navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private fun showCurrentMode(editMode: Boolean) {

        // if we add contact first time
        if (id == null)
            binding.counterparty = counterparty

        binding.fab.apply {
            if (editMode) {
                setImageResource(R.drawable.ic_save)
                setTitleForActionBar("Edit Contact")
            } else {
                setImageResource(R.drawable.ic_edit)
                setTitleForActionBar("Contact")
            }
        }

        val mapInfo = mapOf(
            "name" to binding.etNameDetail,
            "phoneNumber" to binding.etPhone,
            "email" to binding.etEmailAddress
        )

        for ((_, info) in mapInfo) {

            info.apply {
                isFocusable = editMode
                isFocusableInTouchMode = editMode
                isEnabled = editMode
            }

        }

        avatar.isClickable = editMode

        if (avatar.isClickable)
            avatar.setOnClickListener {
                selectImageFromGalleryResult.launch("image/*")
            }
    }

    private fun setTitleForActionBar(string: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = string
    }

    private fun saveProfileInfo() {

        if (id == null) {
            binding.apply {
                counterparty = this@DetailCounterpartyFragment.counterparty.let {
                    it.apply {
                        name = etNameDetail.text.toString()
                        phoneNumber = etPhone.text.toString()
                        email = etEmailAddress.text.toString()
                        avatar = this@DetailCounterpartyFragment.avatar.drawToBitmap()
                    }

                }.apply {
                    detailViewModel.addCounterparty(this)
                    this@DetailCounterpartyFragment.id = id
                }
            }

        } else {
            binding.apply {
                counterparty = this@DetailCounterpartyFragment.counterparty.let {
                    it.apply {
                        name = etNameDetail.text.toString()
                        phoneNumber = etPhone.text.toString()
                        email = etEmailAddress.text.toString()
                        avatar = this@DetailCounterpartyFragment.avatar.drawToBitmap()
                    }

                }.apply {
                    detailViewModel.updateCounterparty(this)
                }
            }
        }

    }

    private fun activityResultLauncher() =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri.let { avatar.setImageURI(it) }
        }

}