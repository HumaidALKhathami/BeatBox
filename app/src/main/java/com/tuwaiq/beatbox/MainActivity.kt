package com.tuwaiq.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.beatbox.databinding.ActivityMainBinding
import com.tuwaiq.beatbox.databinding.ListItemSoundBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val beatBox = BeatBox(assets)



        binding.soundsRv.apply {
            layoutManager = GridLayoutManager(context,3)

            adapter = SoundAdapter(beatBox.loadSounds())
        }

    }

    private inner class SoundHolder(val binding: ListItemSoundBinding ) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.viewModel = SoundViewModel()
        }

        fun bind (sound: Sounds) {
            binding.apply {
                viewModel?.sound = sound
                binding.executePendingBindings()
            }
        }
    }

    private inner class SoundAdapter(val sounds: List<Sounds>) : RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(layoutInflater, R.layout.list_item_sound,parent,false)

            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound = sounds[position]

            holder.bind(sound)
        }

        override fun getItemCount(): Int = sounds.size


    }
}