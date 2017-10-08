package io.smallant.baseclasses.sample.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import io.smallant.baseclasses.sample.features.home.HomeActivity

/**
 * Created by Jonathan on 08/10/2017.
 */

@Module(subcomponents = arrayOf(
        ActivityModule.HomeActivitySubComponent::class))
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    internal abstract fun provideHomeActivityFactory(builder: HomeActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Subcomponent
    interface HomeActivitySubComponent : AndroidInjector<HomeActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<HomeActivity>()
    }

}