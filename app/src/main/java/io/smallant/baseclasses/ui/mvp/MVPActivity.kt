package io.smallant.baseclasses.ui.mvp

import android.os.Bundle
import dagger.android.AndroidInjection
import io.smallant.baseclasses.ui.BaseActivity
import io.smallant.baseclasses.ui.BaseContract
import io.smallant.baseclasses.ui.interfaces.StatutInterface
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by jpannetier on 09/08/2017.
 */
abstract class MVPActivity<P : BaseContract.Presenter> : BaseActivity(), StatutInterface {

    @Inject lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayProgress(value: Boolean) {
        Timber.d("displayProgress $value")
    }

    override fun displayError(message: String) {
        Timber.e("displayError $message")
    }
}