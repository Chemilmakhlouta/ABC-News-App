package chemilmakhlouta.abcnewsproject.application.injection.component

import android.app.Application
import chemilmakhlouta.abcnewsproject.application.injection.module.ActivityModule
import chemilmakhlouta.abcnewsproject.application.injection.module.ApplicationModule
import chemilmakhlouta.abcnewsproject.application.injection.module.NewsModule
import chemilmakhlouta.abcnewsproject.application.injection.module.RetrofitModule
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ActivityModule::class, RetrofitModule::class, NewsModule::class))
interface ApplicationComponent {

    fun inject(application: Application)

    fun getNewsRepository(): NewsRepository
}