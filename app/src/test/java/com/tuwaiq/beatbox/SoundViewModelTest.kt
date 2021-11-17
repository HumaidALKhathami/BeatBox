package com.tuwaiq.beatbox

import org.hamcrest.core.Is
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    private lateinit var beatBox: BeatBox

    @Before
    fun setUp() {
        sound = Sound("assetPath",1)
        beatBox = mock(BeatBox::class.java)
        subject = SoundViewModel(beatBox)

        subject.sound = sound
    }

    @Test
    fun titleEqualsName(){
//        assertThat(sound.name, `is` (subject.title))
//        if (subject.title != null)
        assertEquals(sound.name,subject.title)
    }

    @Test
    fun onButtonClick() {
        subject.onButtonClick()
        verify(beatBox).play(sound)
    }
}