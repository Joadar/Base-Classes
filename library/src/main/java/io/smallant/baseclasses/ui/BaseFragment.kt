package io.smallant.baseclasses.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.smallant.baseclasses.R
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by Jonathan on 30/07/2017.
 */
abstract class BaseFragment : Fragment(), OnClickListener {

    abstract var layoutId: Int

    protected val isTablet: Boolean by lazy { context.resources.getInteger(R.integer.isTablet) == 1 }
    protected val isLandscape: Boolean by lazy { context.resources.getInteger(R.integer.isLandscape) == 1 }
    protected val nbColumn: Int by lazy { resources.getInteger(R.integer.number_column) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (layoutId != 0) {
            return inflater?.inflate(layoutId, container, false)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onItemClicked(view: View, position: Int) {}
    override fun onItemClicked(position: Int) {}
    override fun onShareClicked(position: Int) {}
    override fun onDeleteClicked(position: Int) {}
    override fun onSaveClicked(id: Long) {}
}