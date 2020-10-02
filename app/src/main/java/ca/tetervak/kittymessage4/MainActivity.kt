package ca.tetervak.kittymessage4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ca.tetervak.kittymessage4.model.Envelope
import ca.tetervak.kittymessage4.ui.InputFragment
import ca.tetervak.kittymessage4.ui.OutputFragment

class MainActivity : AppCompatActivity(),
    InputFragment.InputListener, OutputFragment.OutputListener {

    companion object{
        const val INPUT_TO_OUTPUT = "input_to_output"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, InputFragment())
                .commit()
        }
    }

    override fun showOutput(envelope: Envelope) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, OutputFragment.newInstance(envelope))
            .addToBackStack(INPUT_TO_OUTPUT)
            .commit()
    }

    override fun showInput(){
        supportFragmentManager.popBackStack(
            INPUT_TO_OUTPUT, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}