package by.redrix.timeline

import android.app.Activity
import android.app.Application
import by.redrix.timeline.di.component.AppComponent
import by.redrix.timeline.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    override fun activityInjector() = activityDispatchingAndroidInjector

    private fun initDI() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }

}

