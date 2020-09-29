package ca.tetervak.kittymessage4.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ca.tetervak.kittymessage4.R
import ca.tetervak.kittymessage4.model.Envelope

class EnvelopeViewModel(application: Application) : AndroidViewModel(application) {

    private val envelope = Envelope(true, application.getString(R.string.cat_mew))

    private val _mailbox: MutableLiveData<Envelope> =
        MutableLiveData<Envelope>().apply { value = envelope }

    val mailbox: LiveData<Envelope>
        get() = _mailbox

    fun send(envelope: Envelope) {
        _mailbox.value = envelope
    }
}