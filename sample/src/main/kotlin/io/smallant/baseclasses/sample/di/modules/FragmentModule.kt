package io.smallant.baseclasses.sample.di.modules

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import io.smallant.baseclasses.sample.features.home.HomeFragment

/**
 * Created by Jonathan on 08/10/2017.
 */


@Module(subcomponents = arrayOf(
        FragmentModule.HomeFragmentSubComponent::class))
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    internal abstract fun provideHomeFragmentFactory(builder: HomeFragmentSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Subcomponent
    interface HomeFragmentSubComponent : AndroidInjector<HomeFragment> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<HomeFragment>()
    }
}

