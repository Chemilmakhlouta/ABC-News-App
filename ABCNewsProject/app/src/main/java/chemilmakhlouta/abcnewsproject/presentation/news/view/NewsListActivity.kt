package chemilmakhlouta.abcnewsproject.presentation.news.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import chemilmakhlouta.abcnewsproject.R
import chemilmakhlouta.abcnewsproject.application.NewsApplication
import chemilmakhlouta.abcnewsproject.application.injection.component.ActivityComponent
import chemilmakhlouta.abcnewsproject.application.injection.component.DaggerActivityComponent
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import chemilmakhlouta.abcnewsproject.presentation.news.adapter.NewsListAdapter
import chemilmakhlouta.abcnewsproject.presentation.news.presenter.NewsListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import chemilmakhlouta.abcnewsproject.data.news.common.extension.navigateToExternalUrl


class NewsListActivity : Activity(), NewsListPresenter.Display, NewsListPresenter.Router, NewsListAdapter.OnNewsListItemClickListener {

    @Inject
    lateinit var presenter: NewsListPresenter

    private lateinit var newsListAdapter: NewsListAdapter

    // region lifecycle

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

        swipeContainer.setOnRefreshListener { presenter.onSwipeToRefresh() }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        presenter.onStart()
    }

    fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
        presenter.inject(this, this)
    }

    // endregion

    // region NewsListAdapter callbacks
    override fun onNewsItemClicked(url: String) {
        presenter.onNewsClicked(url)
    }
    // endregion

    // region Display
    override fun setUpNewsList(news: MutableList<NewsObject>) {
        val adapter = (newsList.adapter as NewsListAdapter)
        adapter.setNewsList(news)
    }

    override fun showLoading() {
        swipeContainer.isRefreshing = true
    }

    override fun hideLoading() {
        swipeContainer.isRefreshing = false
    }

    override fun showError() {
        Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
    }
    // enregion

    // region Router
    override fun navigateToLink(url: String) {
        applicationContext.navigateToExternalUrl(url)
    }
    // endregion
}
