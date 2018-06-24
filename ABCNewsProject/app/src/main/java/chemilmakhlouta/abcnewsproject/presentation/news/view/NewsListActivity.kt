package chemilmakhlouta.abcnewsproject.presentation.news.view

import android.app.Activity
import android.os.Bundle
import chemilmakhlouta.abcnewsproject.R
import chemilmakhlouta.abcnewsproject.application.injection.component.ActivityComponent
import chemilmakhlouta.abcnewsproject.presentation.news.presenter.NewsListPresenter
import javax.inject.Inject

class NewsListActivity : Activity(), NewsListPresenter.Display, NewsListPresenter.Router {

    @Inject
    lateinit var presenter: NewsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
