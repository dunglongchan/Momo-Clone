package com.example.momo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.momo.databinding.ItemYourPromoBinding
import com.example.momo.fragment.OnItemVoucherCLick
import com.example.momo.model.YourPromoModel
import com.jakewharton.rxbinding3.view.clicks
import java.util.concurrent.TimeUnit

class YourPromoAdapter(val context: Context, val listenr: OnItemVoucherCLick) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItem: ArrayList<YourPromoModel> = ArrayList()

    fun setData(list: ArrayList<YourPromoModel>) {
        this.listItem.clear()
        this.listItem.addAll(list)
    }

    class ViewHolder(binding: ItemYourPromoBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.ivLogo
        val title = binding.tvTitle
        val content = binding.tvContent
        val date = binding.tvDate
        val tvClick = binding.tvClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemYourPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        val item = listItem[position]

        Glide.with(context).load(item.img).into(viewHolder.img)
        viewHolder.title.text = item.title
        viewHolder.content.text = item.content
        viewHolder.date.text = item.date

        viewHolder.itemView.clicks().throttleFirst(1, TimeUnit.SECONDS).subscribe() {
            listenr.onItemClick()
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}