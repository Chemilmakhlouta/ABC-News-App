package chemilmakhlouta.abcnewsproject.presentation.news.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import chemilmakhlouta.abcnewsproject.R
import chemilmakhlouta.abcnewsproject.application.NewsApplication
import chemilmakhlouta.abcnewsproject.application.injection.component.ActivityComponent
import chemilmakhlouta.abcnewsproject.application.injection.component.DaggerActivityComponent
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

        newsList.layoutManager = LinearLayoutManager(this)
        newsListAdapter = NewsListAdapter(this)
        newsListAdapter.setNewsListItemClickListener(this)
        newsList.adapter = newsListAdapter
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        presenter.onStart()
    }

    fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onNewsItemClicked() {
    }

    override fun setUpNewsList(news: MutableList<NewsObject>) {
        val adapter = (newsList.adapter as NewsListAdapter)
        adapter.setNewsList(news)
    }
}
