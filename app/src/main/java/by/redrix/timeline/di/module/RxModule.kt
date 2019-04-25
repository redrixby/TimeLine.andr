package by.redrix.timeline.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RxModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}