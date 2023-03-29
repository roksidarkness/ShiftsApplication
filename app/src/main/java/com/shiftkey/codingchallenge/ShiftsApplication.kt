package com.shiftkey.codingchallenge

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.shiftkey.codingchallenge.di.component.DaggerAppComponent

class ShiftsApplication: DaggerApplication() {
    private val applicationInjector = DaggerAppComponent
        .builder()
        .application(this)
        .build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}