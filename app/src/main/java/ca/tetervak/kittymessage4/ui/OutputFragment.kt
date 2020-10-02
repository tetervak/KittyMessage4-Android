package ca.tetervak.kittymessage4.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage4.model.Envelope


class OutputFragment : Fragment() {

    interface OutputListener{
        fun showInput()
    }
    private var outputListener: OutputFragment.OutputListener? = null

    companion object{
        const val ENVELOPE = "envelope"

        fun newInstance(envelope: Envelope?): OutputFragment{
            val fragment = OutputFragment()
            val arguments = Bundle()
            arguments.putSerializable(ENVELOPE, envelope)
            fragment.arguments = arguments
            return fragment
        }
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

        binding.backButton.setOnClickListener { outputListener?.showInput() }

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

    fun receiveEnvelope(envelope: Envelope){
        this.envelope = envelope
        showEnvelope()
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        outputListener = context as OutputFragment.OutputListener?
    }

    override fun onDetach() {
        super.onDetach()
        outputListener = null
    }
}