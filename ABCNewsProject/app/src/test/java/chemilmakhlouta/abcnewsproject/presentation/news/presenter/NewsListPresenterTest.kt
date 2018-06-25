package chemilmakhlouta.abcnewsproject.presentation.news.presenter

import chemilmakhlouta.abcnewsproject.domain.news.usecase.GetNewsUseCase
import chemilmakhlouta.abcnewsproject.presentation.news.presenter.NewsListPresenter
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.SubjectSpek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@RunWith(JUnitPlatform::class)
class NewsListPresenterTest : SubjectSpek<NewsListPresenter>(
        {
            var display: NewsListPresenter.Display = mock()
            var router: NewsListPresenter.Router = mock()

            var getNewsUseCase: GetNewsUseCase

            val mockUrl = "google.com"

            subject {
                getNewsUseCase = mock()

                val presenter = NewsListPresenter(getNewsUseCase)
                display = mock()
                router = mock()
                presenter.inject(display, router)
                presenter
            }

            given("I am on the news list screen") {
                it("Shows the loading indicator while the news list is fetched") {
                    subject.onStart()

                    verify(display).showLoading()
                }

                it("hides the loading indicator when the result is returned") {
                    subject.onStart()

                    verify(display).hideLoading()
                }

                on("clicking a news item") {
                    it("opens the news item's link in a chrome custom tab") {
                        subject.onNewsClicked(mockUrl)

                        verify(router).navigateToLink(mockUrl)
                    }
                }

                on("swiping the list down") {
                    it("refreshes the list") {
                        subject.onSwipeToRefresh()

                        verify(display).setUpNewsList(any())
                    }
                }
            }

        })