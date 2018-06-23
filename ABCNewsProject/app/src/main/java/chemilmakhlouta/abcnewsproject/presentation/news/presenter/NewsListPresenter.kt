package chemilmakhlouta.abcnewsproject.presentation.news.presenter

import chemilmakhlouta.abcnewsproject.domain.news.usecase.GetNewsUseCase
import javax.inject.Inject

/**
 * Created by Chemil Maklouta on 23/6/18.
 */
class NewsListPresenter @Inject constructor(private val getNewsUseCase: GetNewsUseCase) {

}