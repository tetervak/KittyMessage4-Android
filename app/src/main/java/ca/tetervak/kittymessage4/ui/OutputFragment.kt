package ca.tetervak.kittymessage4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage4.model.Envelope


class OutputFragment : Fragment() {

    companion object{
        const val ENVELOPE = "envelope"
    }

    private lateinit var binding: FragmentOutputBinding

    private lateinit var envelope: Envelope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener { showInput() }

        envelope =
            if (savedInstanceState is Bundle) {
                savedInstanceState.getSerializable(ENVELOPE) as Envelope
            } else {
                val safeArgs: OutputFragmentArgs by navArgs()
                safeArgs.envelope
            }

        binding.envelope = envelope

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

            outState.putSerializable(ENVELOPE, envelope)
    }

    private fun showInput(){
        val action = OutputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }
}