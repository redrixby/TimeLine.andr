package by.redrix.timeline.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    protected lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: V

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    protected abstract fun getViewModelClass(): KClass<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        initViewModel()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass().java)
    }
}