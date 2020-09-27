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

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container_input, InputFragment())
                .commit()
            outputFragment =
                OutputFragment.newInstance(Envelope(true, getString(R.string.cat_mew)))
            supportFragmentManager.beginTransaction()
                .add(R.id.container_output, outputFragment!!)
                .commit()
        }else{
            // lookup the layout fragment
            outputFragment = supportFragmentManager
                .findFragmentById(R.id.container_output) as OutputFragment?
        }
    }

    override fun send(envelope: Envelope) {
        outputFragment?.receiveEnvelope(envelope)
    }
}