package by.redrix.timeline.ui.activity.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.redrix.timeline.ui.activity.auth.AuthActivity
import dagger.android.AndroidInjection

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        decideNextActivity()
    }

    private fun decideNextActivity() {
        val intent = AuthActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    private fun performDI() = AndroidInjection.inject(this)
}