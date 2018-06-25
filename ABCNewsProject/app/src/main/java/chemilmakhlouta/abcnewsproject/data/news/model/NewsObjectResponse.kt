package chemilmakhlouta.abcnewsproject.data.news.model

/**
* Created by Chemil Makhlouta on 23/6/18.
*/
data class NewsObjectResponse(val title: String,
                              val pubDate: String,
                              val thumbnail: String,
                              val link: String,
                              val enclosure: EnclosureResponse)