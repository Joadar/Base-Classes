package io.smallant.baseclasses.ui.interfaces

/**
 * Created by jpannetier on 09/08/2017.
 */

interface StatutInterface {
    fun displayProgress(value: Boolean)
    fun displayError(message: String = "")
}