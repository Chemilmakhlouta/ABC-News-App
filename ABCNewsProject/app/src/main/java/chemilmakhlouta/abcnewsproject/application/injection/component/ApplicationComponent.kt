package chemilmakhlouta.abcnewsproject.application.injection.component

import android.app.Application
import chemilmakhlouta.abcnewsproject.application.injection.module.NewsModule
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@Singleton
@Component(modules = arrayOf(NewsModule::class))
interface ApplicationComponent {

    fun inject(application: Application)

    fun getNewsRepository(): NewsRepository
}