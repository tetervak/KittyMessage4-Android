package ca.tetervak.kittymessage4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage4.model.Envelope


class OutputFragment : Fragment() {

    companion object{
        const val ENVELOPE = "envelope"
    }

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!

    private var envelope: Envelope? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOutputBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener { showInput() }

        envelope =
            if (savedInstanceState is Bundle) {
                savedInstanceState.getSerializable(ENVELOPE)
            } else {
                arguments?.getSerializable(ENVELOPE)
            } as Envelope?

        showEnvelope()

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(envelope != null)
            outState.putSerializable(ENVELOPE, envelope)
    }

    private fun showEnvelope(){

        binding.isUrgentOutput.text =
        when{
            (envelope?.isUrgent == true) -> getString(R.string.urgent)
            (envelope?.isUrgent == false) -> getString(R.string.not_urgent)
            else -> getString(R.string.undefined)
        }

        binding.messageText.text =
            envelope?.textMessage ?: getString(R.string.undefined)

    }

    private fun showInput(){
        findNavController().navigate(R.id.action_output_to_input)
    }
}