package by.redrix.timeline.di.module

import by.redrix.timeline.di.annotation.ActivityScope
import by.redrix.timeline.ui.activity.auth.AuthActivity
import by.redrix.timeline.ui.activity.main.MainActivity
import by.redrix.timeline.ui.activity.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAuthActivity(): AuthActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}