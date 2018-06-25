package chemilmakhlouta.abcnewsproject.application

import android.support.multidex.MultiDexApplication
import chemilmakhlouta.abcnewsproject.application.injection.component.ApplicationComponent
import chemilmakhlouta.abcnewsproject.application.injection.component.DaggerApplicationComponent
import chemilmakhlouta.abcnewsproject.application.injection.module.ApplicationModule


/**
 * Created by Chemil Makhlouta on 25/6/18.
 */
class NewsApplication : MultiDexApplication() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)
    }
}