package chemilmakhlouta.abcnewsproject.data.news

import chemilmakhlouta.abcnewsproject.data.news.model.NewsObjectResponse
import chemilmakhlouta.abcnewsproject.domain.news.model.Enclosure
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
fun mapToDomainNewsList(newsList: List<NewsObjectResponse>?): List<NewsObject> {
    val mappedNewsList: MutableList<NewsObject> = mutableListOf()

    newsList.let {
        it?.map {
            NewsObject(it.title, it.pubDate, it.thumbnail, it.link, Enclosure(it.enclosure.link))
        }?.let {
            mappedNewsList.addAll(it)
        }
    }

    return mappedNewsList
}
