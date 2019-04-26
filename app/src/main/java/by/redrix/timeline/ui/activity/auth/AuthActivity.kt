package by.redrix.timeline.ui.activity.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import by.redrix.timeline.R
import by.redrix.timeline.ui.activity.main.MainActivity
import by.redrix.timeline.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class AuthActivity : BaseActivity<AuthActivityViewModel>() {

    override fun getViewModelClass(): KClass<AuthActivityViewModel> = AuthActivityViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewListeners()
    }

    private fun setViewListeners() {
        btn_login.setOnClickListener {
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AuthActivity::class.java)
    }
}
