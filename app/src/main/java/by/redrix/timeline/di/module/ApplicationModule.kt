package by.redrix.timeline.di.module

import android.content.Context
import by.redrix.timeline.App
import by.redrix.timeline.di.annotation.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @ApplicationScope
    @Provides
    fun provideApplicationContext(application: App): Context = application
}