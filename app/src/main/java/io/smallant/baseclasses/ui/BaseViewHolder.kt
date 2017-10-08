package io.smallant.baseclasses.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by jpannetier on 10/08/2017.
 */
abstract class BaseViewHolder<T>(view: View, clickListener: OnClickListener?) : RecyclerView.ViewHolder(view) {

    abstract fun bind(position: Int, data: T)

    init {
        view.setOnClickListener { clickListener?.onItemClicked(adapterPosition) }
    }
}