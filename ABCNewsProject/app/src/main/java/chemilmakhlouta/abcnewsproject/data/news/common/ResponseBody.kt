package chemilmakhlouta.abcnewsproject.data.news.common

/**
 * Created by Chemil Makhlouta on 24/6/18.
 */
data class ResponseBody<T>(val data: ResponseData<T>?) {

    fun <R> map(transform: (T?) -> R?): R? {
        data?.let {
            return transform(it.items)
        }
        return null
    }

    fun <R> mapNotNull(transform: T.() -> R): R? {
        data?.items?.let {
            return transform(it)
        }
        return null
    }

    fun <R> mapExceptionOnNull(transform: T.() -> R): R {
        data!!.items!!.let {
            return transform(it)
        }
    }
}