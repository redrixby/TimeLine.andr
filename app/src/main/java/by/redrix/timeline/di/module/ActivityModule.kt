package by.redrix.timeline.di.module

import by.redrix.timeline.di.annotation.ActivityScope
import by.redrix.timeline.ui.activity.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAuthActivity(): AuthActivity
}