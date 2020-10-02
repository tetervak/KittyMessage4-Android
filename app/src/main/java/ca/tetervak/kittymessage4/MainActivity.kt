package ca.tetervak.kittymessage4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ca.tetervak.kittymessage4.model.Envelope
import ca.tetervak.kittymessage4.ui.InputFragment
import ca.tetervak.kittymessage4.ui.OutputFragment

class MainActivity : AppCompatActivity(),
    InputFragment.InputListener, OutputFragment.OutputListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showOutput(envelope: Envelope) {
        val arguments = Bundle()
        arguments.putSerializable(OutputFragment.ENVELOPE, envelope)
        findNavController(R.id.nav_host)
            .navigate(R.id.action_input_to_output, arguments)
    }

    override fun showInput(){
        findNavController(R.id.nav_host)
            .navigate(R.id.action_output_to_input)
    }
}