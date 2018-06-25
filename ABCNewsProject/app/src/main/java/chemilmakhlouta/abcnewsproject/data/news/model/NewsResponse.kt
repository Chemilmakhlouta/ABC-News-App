package chemilmakhlouta.abcnewsproject.data.news.model

/**
 * Created by Chemil Makhlouta on 25/6/18.
 */
data class NewsResponse(val status: String,
                        val items: List<NewsObjectResponse>)