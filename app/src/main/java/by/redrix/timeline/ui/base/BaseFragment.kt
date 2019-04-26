package by.redrix.timeline.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment<T: ViewDataBinding, V: BaseViewModel> : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    abstract val viewModel: V

    @get:LayoutRes
    abstract val layoutId: Int
    lateinit var viewDataBinding: T
    open val bindingVariables: Map<Int, Any>? = null


    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindingVariables?.forEach { (variable, obj) -> viewDataBinding.setVariable(variable, obj) }
        viewDataBinding.executePendingBindings()
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }
}