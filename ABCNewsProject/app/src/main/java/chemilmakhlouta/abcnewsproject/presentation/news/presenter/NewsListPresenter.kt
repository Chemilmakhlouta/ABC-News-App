package chemilmakhlouta.abcnewsproject.presentation.news.presenter

import android.util.Log
import chemilmakhlouta.abcnewsproject.application.Presenter
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import chemilmakhlouta.abcnewsproject.domain.news.usecase.GetNewsUseCase
import io.reactivex.Single
import io.reactivex.disposables.Disposables
import javax.inject.Inject

/**
 * Created by Chemil Maklouta on 23/6/18.
 */
class NewsListPresenter @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : Presenter {

    private lateinit var display: Display
    private lateinit var router: Router

    private var getNewsListObservable: Single<List<NewsObject>>? = null
    private var getNewsListSubscription = Disposables.disposed()

    fun inject(display: Display, router: Router) {
        this.display = display
        this.router = router
    }

    override fun onStart() {
        getNews()
    }

    fun onSwipeToRefresh() = getNews()

    override fun onResume() = subscribeToGetNews()

    override fun onPause() = getNewsListSubscription.dispose()

    override fun onStop() {
        getNewsListObservable = null
    }

    private fun getNews() {
        if (getNewsListObservable == null) {
            getNewsListObservable = getNewsUseCase.getNews()
                    .doOnSubscribe { display.showLoading() }
                    .doAfterTerminate {
                        display.hideLoading()
                        getNewsListObservable = null
                    }

            subscribeToGetNews()
        }
    }

    private fun subscribeToGetNews() {
        getNewsListObservable?.let {
            if (getNewsListSubscription.isDisposed) {
                getNewsListSubscription = it.subscribe(this::onNewsListSuccess, this::onNewsListFailure)
            }
        }
    }

    private fun onNewsListSuccess(news: List<NewsObject>) =
            if (news.isEmpty()) {
//                display.showEmptyNewsList()
            } else {
//                display.showNewsList()
                display.setUpNewsList(mutableListOf<NewsObject>().apply {
                    addAll(news)
                })
            }

    private fun onNewsListFailure(throwable: Throwable) {
        Log.e("Presenter", throwable.message)
    }

    interface Display {
        fun showLoading()
        fun hideLoading()
        fun setUpNewsList(news: MutableList<NewsObject>)

    }

    interface Router {

    }
}