package chemilmakhlouta.abcnewsproject.data.news

import chemilmakhlouta.abcnewsproject.data.news.model.NewsObjectResponse
import chemilmakhlouta.abcnewsproject.domain.news.NewsRepository
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
class NewsService @Inject constructor(retrofit: Retrofit) : NewsRepository {

    private val client = retrofit.create(NewsClient::class.java)

    override fun getNews(): Single<List<NewsObject>> =
            client.getNews().map { mapToDomainNewsList() }


    private interface NewsClient {
        @GET("https://api.rss2json.com/v1/api.json?rss_url=http://www.abc.net.au/news/feed/51120/rss.xml")
        fun getNews(): Single<List<NewsObjectResponse>>
    }

}