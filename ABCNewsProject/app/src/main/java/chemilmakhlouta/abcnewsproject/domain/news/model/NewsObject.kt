package chemilmakhlouta.abcnewsproject.domain.news.model

/**
 * Created by Chemil Makhlouta on 23/6/18.
 */
data class NewsObject(val title: String,
                      val pubDate: String,
                      val guid: String,
                      val author: String,
                      val thumbnail: String,
                      val description: String,
                      val content: String)