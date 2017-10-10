package io.smallant.baseclasses.sample.features.home

import android.os.Bundle
import android.view.View
import io.smallant.baseclasses.sample.R
import io.smallant.baseclasses.ui.BaseFragmentRecycler
import io.smallant.baseclasses.utils.ShareUtils

/**
 * Created by Jonathan on 08/10/2017.
 */
class HomeFragment : BaseFragmentRecycler<HomePresenter, StringsRecyclerAdapter, StringsRecyclerAdapter.StringViewHolder, String>(),
        HomeContract.View {

    override var layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        presenter.view = this

        adapter = StringsRecyclerAdapter(context, arrayListOf())
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClicked(position: Int) {
        ShareUtils.share(context, "${items[position]} clicked!")
        //context.toast("${items[position]} clicked!")
    }
}