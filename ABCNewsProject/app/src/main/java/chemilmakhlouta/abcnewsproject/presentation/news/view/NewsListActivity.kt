package chemilmakhlouta.abcnewsproject.presentation.news.view

import android.app.Activity
import android.os.Bundle
import chemilmakhlouta.abcnewsproject.R
import chemilmakhlouta.abcnewsproject.application.NewsApplication
import chemilmakhlouta.abcnewsproject.application.injection.component.ActivityComponent
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import chemilmakhlouta.abcnewsproject.presentation.news.adapter.NewsListAdapter
import chemilmakhlouta.abcnewsproject.presentation.news.presenter.NewsListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NewsListActivity : Activity(), NewsListPresenter.Display, NewsListPresenter.Router, NewsListAdapter.OnNewsListItemClickListener {

    @Inject
    lateinit var presenter: NewsListPresenter

    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(NewsApplication.applicationComponent)
                .build()
        inject(activityComponent)

        setContentView(R.layout.activity_main)


        newsListAdapter = NewsListAdapter(this)
        newsListAdapter.setNewsListItemClickListener(this)
        newsList.adapter = newsListAdapter
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

    override fun onNewsItemClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUpNewsList(news: MutableList<NewsObject>) {
        val adapter = (newsList.adapter as NewsListAdapter)
        adapter.setNewsList(news)
    }
}
