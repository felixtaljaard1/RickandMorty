package com.example.rickyapp.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickyapp.data.entities.ResultCharacter
import com.example.rickyapp.databinding.CharacterRowBinding


/**
*  extend listadapter<Entity, viewholder>
 *      create diffutil
 *      include this is characteradapter extension
 *      viewholder caches view references
 *      inside character adapter class create myviewholder class(viewbinding)
 *      override methods
 *      oncreateviewholder
 *
 * click listener
 * doesnt have its own callback for click: custom
 * 1. create inner class onclicklistener: onclick
 * 2. in constructor pass onclicklistener as parameter
 * 3. onbind() -> onclicklistener
 *  */


class CharacterAdapter(private val onClickListener: OnClickListener): ListAdapter<ResultCharacter, CharacterAdapter.MyViewHolder>(CharacterItemDiffCallback()) {

    class OnClickListener(val clickListener: (character: ResultCharacter) -> Unit){
        // delegate fun
        fun onClick(character: ResultCharacter) = clickListener(character)
    }

    class MyViewHolder(val characterRowBinding: CharacterRowBinding) : RecyclerView.ViewHolder(characterRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = CharacterRowBinding.inflate(view, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // data == view
        val characterList = getItem(position)
        holder.characterRowBinding.tvName.text = characterList.name

        Glide.with(holder.itemView.context)
            .load(characterList.image)
            .into(holder.characterRowBinding.tvImage)

        holder.itemView.setOnClickListener{
            onClickListener.onClick(characterList)
        }
    }
}

class CharacterItemDiffCallback: DiffUtil.ItemCallback<ResultCharacter>(){
    override fun areItemsTheSame(oldItem: ResultCharacter, newItem: ResultCharacter): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: ResultCharacter, newItem: ResultCharacter): Boolean =
        oldItem == newItem

}