package io.smallant.baseclasses.sample.features.home

import io.smallant.baseclasses.ui.BaseContract

/**
 * Created by Jonathan on 08/10/2017.
 */
interface HomeContract {
    interface View: BaseContract.View<List<String>>
    interface Presenter: BaseContract.Presenter
}