package chemilmakhlouta.abcnewsproject.domain.news

import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import io.reactivex.Single

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
interface NewsRepository {
    fun getNews(): Single<List<NewsObject>>
}