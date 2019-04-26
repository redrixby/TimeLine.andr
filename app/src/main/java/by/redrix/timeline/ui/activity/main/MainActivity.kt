package by.redrix.timeline.ui.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import by.redrix.timeline.R
import by.redrix.timeline.ui.base.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override fun getViewModelClass() = MainActivityViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}