package com.tuwaiq.beatbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel: BaseObservable() {

    var sound:Sounds? = null
        set(sound) {
            field = sound
            notifyChange()
        }
    @get:Bindable
    val title:String?
        get() = sound?.name



}