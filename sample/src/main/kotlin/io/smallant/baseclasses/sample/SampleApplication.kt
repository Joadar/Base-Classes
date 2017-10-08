package io.smallant.baseclasses.sample

import android.app.Activity
import io.smallant.baseclasses.sample.di.components.DaggerAppComponent
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Jonathan on 08/10/2017.
 */
class SampleApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingActivityAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingActivityAndroidInjector

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}
