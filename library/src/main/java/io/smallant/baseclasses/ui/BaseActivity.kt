package io.smallant.baseclasses.ui

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.smallant.baseclasses.R
import io.smallant.baseclasses.extensions.replaceFragmentSafely
import io.smallant.baseclasses.ui.interfaces.OnClickListener

/**
 * Created by Jonathan on 30/07/2017.
 */
abstract class BaseActivity : AppCompatActivity(), OnClickListener {

    protected val isTablet: Boolean by lazy { resources.getInteger(R.integer.isTablet) == 1 }
    protected val isLandscape: Boolean by lazy { resources.getInteger(R.integer.isLandscape) == 1 }
    protected val nbColumn: Int by lazy { resources.getInteger(R.integer.number_column) }

    abstract val layoutId: Int

    companion object {
        val DIALOG_TAG = "dialog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    open fun replaceFragment(container: Int, fragment: Fragment) {
        replaceFragmentSafely(
                fragment = fragment,
                containerViewId = container,
                allowStateLoss = true,
                tag = "main_container"
        )
    }

    override fun onItemClicked(view: View, position: Int) {}
    override fun onItemClicked(position: Int) {}
    override fun onShareClicked(position: Int) {}
    override fun onDeleteClicked(position: Int) {}
    override fun onSaveClicked(id: Long) {}

    fun showDialog(dialog: DialogFragment) {
        if (isFinishing)
            return

        getDialog()?.dismiss()

        val handler = Handler()
        handler.post {
            val fm = supportFragmentManager
            if (!isFinishing && !fm.isStateSaved)
                dialog.show(fm, DIALOG_TAG)
        }
    }

    private fun getDialog(): DialogFragment? = supportFragmentManager.findFragmentByTag(DIALOG_TAG) as DialogFragment?

}