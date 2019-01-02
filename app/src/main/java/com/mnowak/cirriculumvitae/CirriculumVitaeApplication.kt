package com.mnowak.cirriculumvitae
import com.mnowak.cirriculumvitae.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class CirriculumVitaeApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerApplicationComponent.builder()
                .application(this)
                .build()
        component.inject(this)
        return component
    }
}
