package com.shiftkey.codingchallenge.di.component

import com.shiftkey.codingchallenge.ShiftsApplication
import com.shiftkey.codingchallenge.di.module.AppModule
import com.shiftkey.codingchallenge.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<ShiftsApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ShiftsApplication): Builder

        fun build(): AppComponent

    }

    override fun inject(app: ShiftsApplication)
}