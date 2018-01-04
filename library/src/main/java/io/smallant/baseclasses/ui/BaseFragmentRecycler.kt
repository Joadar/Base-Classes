package io.smallant.baseclasses.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.smallant.baseclasses.extensions.gone
import io.smallant.baseclasses.extensions.visible
import io.smallant.baseclasses.ui.mvp.MVPFragment
import kotlinx.android.synthetic.main.include_empty.*
import kotlinx.android.synthetic.main.include_recycler.*

/**
 * Created by Jonathan on 08/10/2017.
 */
abstract class BaseFragmentRecycler<P : BaseContract.Presenter, A : BaseRecyclerAdapter<T, VH>, VH : BaseViewHolder<T>, T> :
        MVPFragment<P>(),
        BaseContract.View<List<T>>{

    protected var items = listOf<T>()
    protected lateinit var adapter: A

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        presenter.getData()
    }

    override fun onDestroyView() {
        adapter.onClickListener = null
        list.adapter = null
        super.onDestroyView()
    }

    override fun displayData(value: List<T>) {
        items = value
        adapter.setItems(items)

        if (items.isEmpty()) {
            empty?.visible()
        } else {
            empty?.gone()
        }
    }

    override fun displayError(message: String) {
        empty?.visible()
    }

    override fun displayProgress(value: Boolean) {}

    private fun initAdapter() {
        adapter.onClickListener = this

        val layoutManager = LinearLayoutManager(context)

        list.adapter = this.adapter
        list.setHasFixedSize(true)
        list.layoutManager = layoutManager
    }
}