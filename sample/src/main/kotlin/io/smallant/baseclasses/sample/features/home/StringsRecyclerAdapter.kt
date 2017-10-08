package io.smallant.baseclasses.sample.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.smallant.baseclasses.ui.BaseRecyclerAdapter
import io.smallant.baseclasses.ui.BaseViewHolder
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by Jonathan on 08/10/2017.
 */
class StringsRecyclerAdapter(context: Context, items: ArrayList<String>) : BaseRecyclerAdapter<String, StringsRecyclerAdapter.StringViewHolder>(context, items) {

    override fun setViewHolder(parent: ViewGroup, viewType: Int, clickListener: OnClickListener?): StringViewHolder =
            StringViewHolder(LayoutInflater.from(context).inflate(android.R.layout.activity_list_item, parent, false), clickListener)

    inner class StringViewHolder(val view: View, clickListener: OnClickListener?) : BaseViewHolder<String>(view, clickListener) {
        val content: TextView by lazy { view.findViewById<TextView>(android.R.id.text1) }

        override fun bind(position: Int, data: String) {
            content.text = data
        }
    }
}