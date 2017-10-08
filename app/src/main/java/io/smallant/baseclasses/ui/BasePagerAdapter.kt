package io.smallant.baseclasses.ui

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by jpannetier on 10/08/2017.
 */
abstract class BasePagerAdapter<T>(val context: Context) : PagerAdapter(), View.OnClickListener {

    var onClickListener: OnClickListener? = null

    val items: MutableList<T> = mutableListOf()

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    abstract fun inflateView(container: ViewGroup?, position: Int): View
    abstract fun bindView(view: View, item: T)

    override fun isViewFromObject(view: View?, obj: Any?) = view == obj
    override fun getCount() = items.size

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val view = inflateView(container, position)
        view.setOnClickListener(this)
        view.tag = position
        bindView(view, items[position])
        container?.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup?, position: Int, view: Any?) {
        if (view is View) {
            view.setOnClickListener(null)
            container?.removeView(view)
        }
    }

    override fun onClick(view: View?) {
        view?.tag?.let {
            onClickListener?.onItemClicked(view.tag as Int)
        }
    }

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
}