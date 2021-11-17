package com.tuwaiq.beatbox

import android.content.res.AssetManager
import android.util.Log
import java.lang.Exception

private const val SOUNDS_FOLDER = "sample_sound"
private const val TAG = "BeatBox"

class BeatBox(private val assets : AssetManager) {

    fun loadSounds():List<Sounds> {

        val soundName:Array<String>

        try {
            soundName = assets.list(SOUNDS_FOLDER)!!
        }catch (e:Exception){
            Log.e(TAG,"there is a problem",e)
            return emptyList()
        }

        val sounds = mutableListOf<Sounds>()

        soundName.forEach { fileName ->
            val assetsPath = "$SOUNDS_FOLDER/$fileName"
            val sound = Sounds(assetsPath)
            sounds.add(sound)
        }

        return sounds
    }

}