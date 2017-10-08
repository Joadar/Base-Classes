package io.smallant.baseclasses.sample.features.home

import io.reactivex.Observable
import io.smallant.baseclasses.ui.BasePresenter
import javax.inject.Inject

/**
 * Created by Jonathan on 08/10/2017.
 */
class HomePresenter @Inject constructor() : BasePresenter<HomeContract.View, List<String>>(),
        HomeContract.Presenter {

    override fun getData() {
        super.getData(Observable.just(listOf("Hello", "World", ",", "It's", "a", "simple", "sample")))
    }
}