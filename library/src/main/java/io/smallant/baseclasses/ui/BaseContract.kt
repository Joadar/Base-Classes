package io.smallant.baseclasses.ui

import io.smallant.baseclasses.ui.interfaces.StatutInterface

/**
 * Created by Jonathan on 05/08/2017.
 */
interface BaseContract {
    interface View<T> : StatutInterface {
        fun displayData(value: T)
    }

    interface Presenter {
        fun getData()
        fun onDestroy()
    }
}