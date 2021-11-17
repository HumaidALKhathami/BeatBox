package com.tuwaiq.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(val beatBox: BeatBox): BaseObservable() {

    var sound:Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }
    @get:Bindable
    val title:String?
        get() = sound?.name

    fun onButtonClick(){

        sound?.let {
            beatBox.play(it)
        }

    }

}