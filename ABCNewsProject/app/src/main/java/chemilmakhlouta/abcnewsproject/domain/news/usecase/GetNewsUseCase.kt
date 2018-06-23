package chemilmakhlouta.abcnewsproject.domain.news.usecase

import chemilmakhlouta.abcnewsproject.application.injection.annotation.Mockable
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@Mockable
class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    fun getNews(): Single<List<NewsObject>> = newsRepository.getNews()
}