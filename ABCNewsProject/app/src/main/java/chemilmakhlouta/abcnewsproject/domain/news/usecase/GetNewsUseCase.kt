package chemilmakhlouta.abcnewsproject.domain.news.usecase

import chemilmakhlouta.abcnewsproject.application.injection.annotation.Mockable
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import javax.inject.Inject

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
@Mockable
class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

}