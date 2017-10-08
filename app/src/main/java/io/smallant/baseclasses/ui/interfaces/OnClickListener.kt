package io.smallant.baseclasses.ui.interfaces

import android.view.View

/**
 * Created by jpannetier on 10/08/2017.
 */

interface OnClickListener {
    fun onItemClicked(view: View, position: Int)
    fun onItemClicked(position: Int)
    fun onShareClicked(position: Int)
    fun onDeleteClicked(position: Int)
    fun onSaveClicked(id: Long)
}