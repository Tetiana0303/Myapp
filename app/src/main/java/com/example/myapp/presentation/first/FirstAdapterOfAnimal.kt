package com.example.myapp.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp.data.Animal
import com.example.myapp.R

class FirstAdapterOfAnimal(
    val onClick: (position: Int) -> Unit
) :RecyclerView.Adapter<FirstAdapterOfAnimal.AnimalViewHolder>()  {

    val listOfAnimals = ArrayList<Animal>()

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewAnimalName : TextView = itemView.findViewById(R.id.nameOfAnmal)
        var textViewAnimalShortDescription : TextView = itemView.findViewById(R.id.shortDesciption)
        var image : ImageView = itemView.findViewById(R.id.imageAnimal)
    }

    fun setArrayListOfAnimals(arrayOfAnimals: List<Animal> ){
        this.listOfAnimals.clear()
        this.listOfAnimals.addAll(arrayOfAnimals)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.animal_card,parent,false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfAnimals.size
    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(listOfAnimals.get(position).urlPhoto).fitCenter().into(holder.image)
        holder.textViewAnimalName.text = listOfAnimals.get(position).name
        holder.textViewAnimalShortDescription.text = listOfAnimals.get(position).shortDesc

        holder.itemView.setOnClickListener {
            onClick(position)
        }

    }

}