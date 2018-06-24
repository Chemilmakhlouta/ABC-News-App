package chemilmakhlouta.abcnewsproject.application.injection.component

import chemilmakhlouta.abcnewsproject.application.injection.annotation.PerScreen
import chemilmakhlouta.abcnewsproject.application.injection.module.ActivityModule
import chemilmakhlouta.abcnewsproject.presentation.news.view.NewsListActivity
import dagger.Component

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@PerScreen
@Component(dependencies = arrayOf(ApplicationComponent::class),
           modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: NewsListActivity)
}