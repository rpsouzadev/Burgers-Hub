package com.example.burgershub.presenter.burgers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgershub.databinding.BurgerItemBinding
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.util.formattedValue
import com.squareup.picasso.Picasso

class BurgersAdapter(
  context: Context,
  private val burgerList: List<Burger>,
  private val burgerClick: (String) -> Unit
) : RecyclerView.Adapter<BurgersAdapter.MyViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(
      BurgerItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }

  override fun getItemCount(): Int {
    return burgerList.size
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val burger = burgerList[position]

    holder.binding.textName.text = burger.name
    holder.binding.textDescription.text = burger.desc
    holder.binding.textPrice.text = burger.price.formattedValue()

    Picasso.get()
      .load(burger.images?.get(1)?.lg)
      .fit().centerCrop()
      .into(holder.binding.imageBurger)

    holder.itemView.setOnClickListener { burgerClick(burger.id ?: "") }
  }

  inner class MyViewHolder(val binding: BurgerItemBinding) : RecyclerView.ViewHolder(binding.root)

}