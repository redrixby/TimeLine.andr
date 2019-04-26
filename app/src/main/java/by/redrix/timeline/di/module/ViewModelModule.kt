package by.redrix.timeline.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.redrix.timeline.di.annotation.ViewModelKey
import by.redrix.timeline.ui.activity.auth.AuthActivityViewModel
import by.redrix.timeline.ui.activity.main.MainActivityViewModel
import by.redrix.timeline.ui.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthActivityViewModel::class)
    fun authActivity(viewModel: AuthActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun mainActivity(viewModel: MainActivityViewModel): ViewModel
}
