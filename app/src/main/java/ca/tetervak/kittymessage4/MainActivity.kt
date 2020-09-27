package ca.tetervak.kittymessage4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.tetervak.kittymessage4.model.Envelope
import ca.tetervak.kittymessage4.ui.InputFragment
import ca.tetervak.kittymessage4.ui.OutputFragment

class MainActivity : AppCompatActivity(), InputFragment.InputListener {

    // it is the layout fragment
    private var outputFragment: OutputFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // lookup the layout fragment
        outputFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_output) as OutputFragment?

    }

    override fun send(envelope: Envelope) {
        outputFragment?.receiveEnvelope(envelope)
    }
}