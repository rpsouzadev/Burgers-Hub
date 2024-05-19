package com.example.burgershub.presenter.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgershub.databinding.IngredientItemBinding
import com.example.burgershub.domain.model.Ingredient
import com.squareup.picasso.Picasso

class IngredientsAdapter(
  private val ingredientList: List<Ingredient>,
) : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(
      IngredientItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }

  override fun getItemCount(): Int {
    return ingredientList.size
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val ingredient = ingredientList[position]

    holder.binding.textName.text = ingredient.name

    Picasso.get()
      .load(ingredient.img)
      .fit().centerCrop()
      .into(holder.binding.imageBurger)
  }

  inner class MyViewHolder(val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root)

}