package chemilmakhlouta.abcnewsproject.domain.news.model

/**
* Created by Chemil Makhlouta on 23/6/18.
*/
data class NewsObject(val title: String,
                      val pubDate: String,
                      val thumbnail: String,
                      val link: String,
                      val enclosure: Enclosure)