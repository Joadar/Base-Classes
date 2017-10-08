package io.smallant.baseclasses.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by Jonathan on 06/08/2017.
 */
abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>>(val context: Context, val items: ArrayList<T>) : RecyclerView.Adapter<VH>() {

    var onClickListener: OnClickListener? = null

    abstract fun setViewHolder(parent: ViewGroup, viewType: Int, clickListener: OnClickListener?): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = setViewHolder(parent, viewType, onClickListener)
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(position, items[position])
    override fun getItemCount() = items.size

    fun setItems(data: List<T>) {
        items.clear()
        addItems(data)
    }

    fun addItems(data: List<T>) {
        items.addAll(data)
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int) = items[position]

}