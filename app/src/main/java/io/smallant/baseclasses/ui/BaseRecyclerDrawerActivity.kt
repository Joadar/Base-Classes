package io.smallant.baseclasses.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by jpannetier on 11/08/2017.
 */
abstract class BaseRecyclerDrawerActivity<T, VH : BaseViewHolder<T>> : BaseDrawerActivity() {

    protected var items: ArrayList<T> = arrayListOf()
    abstract val recyclerAdapter: BaseRecyclerAdapter<T, VH>
    abstract val recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
    }

    fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = recyclerAdapter
            setHasFixedSize(true)
        }
    }

}