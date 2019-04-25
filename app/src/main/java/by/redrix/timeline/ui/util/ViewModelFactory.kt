package by.redrix.timeline.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.redrix.timeline.di.annotation.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@ApplicationScope
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        requireNotNull(viewModels[modelClass]?.get()) as T
}