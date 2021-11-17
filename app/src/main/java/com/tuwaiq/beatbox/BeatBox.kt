package com.tuwaiq.beatbox

import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException
import java.lang.Exception

private const val SOUNDS_FOLDER = "sample_sound"
private const val TAG = "BeatBox"
private const val MAX_SOUNDS = 5

class BeatBox(private val assets : AssetManager) {

    private val soundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()

    private fun load(sound : Sound){
        // asset file descriptor  can be simplified to afd
        val assetFileDescriptor = assets.openFd(sound.assetPath)

        val soundId = soundPool.load(assetFileDescriptor,1)

        sound.soundId = soundId
    }

    fun play(sound: Sound){
        sound.soundId?.let {
            soundPool.play(it,1.0f,1.0f,1,0,1.0f)
        }
    }

    fun release(){
        soundPool.release()
    }

    fun loadSounds():List<Sound> {

        val soundName:Array<String>

        try {
            soundName = assets.list(SOUNDS_FOLDER)!!
        }catch (e:Exception){
            Log.e(TAG,"there is a problem",e)
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()

        soundName.forEach { fileName ->
            val assetsPath = "$SOUNDS_FOLDER/$fileName"
            val sound = Sound(assetsPath)

            try {
                load(sound)
                sounds.add(sound)
            }catch (ioe: IOException){

            }

        }

        return sounds
    }

}