package ca.tetervak.kittymessage4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import ca.tetervak.kittymessage4.model.Envelope
import ca.tetervak.kittymessage4.ui.InputFragment
import ca.tetervak.kittymessage4.ui.OutputFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    InputFragment.InputListener, OutputFragment.OutputListener {

    companion object{
        const val INPUT_TO_OUTPUT = "input_to_output"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showOutput(envelope: Envelope) {
        val arguments = Bundle()
        arguments.putSerializable(OutputFragment.ENVELOPE, envelope)
        Navigation.findNavController(this, R.id.nav_host)
            .navigate(R.id.action_input_to_output, arguments)
    }

    override fun showInput(){
        Navigation.findNavController(this, R.id.nav_host)
            .navigate(R.id.action_output_to_input)
    }
}