package ca.tetervak.kittymessage4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage4.model.Envelope


class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    private val viewModel: EnvelopeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewModel.mailbox.observe(viewLifecycleOwner){ showEnvelope(it) }

        return binding.root
    }

    private fun showEnvelope(envelope: Envelope){

        binding.isUrgentOutput.text =
            if(envelope.isUrgent)
                getString(R.string.urgent)
            else
                getString(R.string.not_urgent)

        binding.messageText.text = envelope.textMessage
    }
}