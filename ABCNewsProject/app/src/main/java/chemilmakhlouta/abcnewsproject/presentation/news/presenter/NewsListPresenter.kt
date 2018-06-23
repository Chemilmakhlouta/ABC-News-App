package chemilmakhlouta.abcnewsproject.presentation.news.presenter

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

    private fun onNewsListSuccess(news: List<NewsObject>) {

    }

    private fun onNewsListFailure(throwable: Throwable) {

    }

    interface Display {
        fun showLoading()
        fun hideLoading()

    }

    interface Router {

    }
}