package by.redrix.timeline.di.component

import by.redrix.timeline.App
import by.redrix.timeline.di.annotation.ApplicationScope
import by.redrix.timeline.di.module.ActivityModule
import by.redrix.timeline.di.module.ApplicationModule
import by.redrix.timeline.di.module.RxModule
import by.redrix.timeline.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        RxModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}