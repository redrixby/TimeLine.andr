package by.redrix.timeline.ui.activity.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import by.redrix.timeline.R
import by.redrix.timeline.ui.base.BaseActivity
import kotlin.reflect.KClass

class AuthActivity : BaseActivity<AuthActivityViewModel>() {

    override fun getViewModelClass(): KClass<AuthActivityViewModel> = AuthActivityViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AuthActivity::class.java)
    }
}
