package io.smallant.baseclasses.ui

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Jonathan on 05/08/2017.
 */
abstract class BasePresenter<V : BaseContract.View<T>, T> : BaseContract.Presenter {

    private var disposable: Disposable? = null
    var view: V? = null

    fun getData(data: Observable<T>) {
        view?.displayProgress(true)

        disposable = data
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view?.displayProgress(false)
                    view?.displayData(it)
                }, {
                    Timber.e("getData() for $data -> ${it.message}")
                    view?.displayProgress(false)
                    view?.displayError(it.message ?: "")
                })
    }

    override fun onDestroy() {
        disposable?.dispose()
    }
}