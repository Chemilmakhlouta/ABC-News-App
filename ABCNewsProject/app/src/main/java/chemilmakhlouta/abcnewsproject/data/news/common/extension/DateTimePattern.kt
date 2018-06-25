package chemilmakhlouta.abcnewsproject.data.news.common.extension

/**
 * Created by Chemil Makhlouta on 25/6/18.
 */
enum class DateTimePattern(private val dateTimePatternString: String) {
    SERVER_DATE_TIME("yyyy-mm-dd hh:mm:ss"),
    DISPLAY_DATE_TIME("MMM dd, yyyy hh:mm aa");

    override fun toString(): String = dateTimePatternString
}