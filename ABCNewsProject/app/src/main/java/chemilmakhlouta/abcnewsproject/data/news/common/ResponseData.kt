package chemilmakhlouta.abcnewsproject.data.news.common

/**
 * Created by Chemil Makhlouta on 24/6/18.
 */
data class ResponseData<out T>(val status: String?, val items: T?)