package io.smallant.baseclasses.ui.mvp

import android.content.Context
import dagger.android.support.AndroidSupportInjection
import io.smallant.baseclasses.extensions.gone
import io.smallant.baseclasses.extensions.visible
import io.smallant.baseclasses.ui.BaseContract
import io.smallant.baseclasses.ui.BaseFragment
import io.smallant.baseclasses.ui.interfaces.StatutInterface
import kotlinx.android.synthetic.main.include_progress.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by jpannetier on 09/08/2017.
 */
abstract class MVPFragment<P : BaseContract.Presenter> : BaseFragment(), StatutInterface {

    @Inject protected lateinit var presenter: P

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDestroyView() {
        presenter.onDestroy()
        super.onDestroyView()
    }

    override fun displayProgress(value: Boolean) {
        Timber.d("displayProgress $value")

        if (value)
            progress?.visible()
        else
            progress?.gone()
    }

    override fun displayError(message: String) {
        Timber.e("displayError $message")
    }
}