package io.smallant.baseclasses.sample.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.smallant.baseclasses.sample.SampleApplication
import io.smallant.baseclasses.sample.di.modules.ActivityModule
import io.smallant.baseclasses.sample.di.modules.AppModule
import io.smallant.baseclasses.sample.di.modules.FragmentModule
import javax.inject.Singleton

/**
 * Created by Jonathan on 08/10/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: SampleApplication)
}