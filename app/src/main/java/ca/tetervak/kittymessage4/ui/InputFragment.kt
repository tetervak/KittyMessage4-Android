package ca.tetervak.kittymessage4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.databinding.FragmentInputBinding
import ca.tetervak.kittymessage4.model.Envelope

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private val viewModel: EnvelopeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        binding.sendButton.setOnClickListener { send() }

        return binding.root
    }

    private fun send() {
        // get urgent flag value
        val isUrgent: Boolean = binding.urgentCheckBox.isChecked
        // get the selected message text
        val textMessage =
            when (binding.messageGroup.checkedRadioButtonId) {
                R.id.purr_button -> getString(R.string.cat_purr)
                R.id.mew_button -> getString(R.string.cat_mew)
                R.id.hiss_button -> getString(R.string.cat_hiss)
                else -> getString(R.string.undefined)
            }
        viewModel.send(Envelope(isUrgent, textMessage))
    }

}