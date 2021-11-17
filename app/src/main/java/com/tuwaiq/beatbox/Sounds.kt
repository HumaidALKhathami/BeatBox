package com.tuwaiq.beatbox

private const val WAV = ".wav"

class Sounds(assetPath:String) {

    val name = assetPath.split("/").last().removeSuffix(WAV)

}