package chemilmakhlouta.abcnewsproject.data.news.common.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Chemil Makhlouta on 25/6/18.
 */

fun String.parseDateTime(currentFormat: DateTimePattern = DateTimePattern.SERVER_DATE_TIME,
                         requiredFormat: DateTimePattern = DateTimePattern.DISPLAY_DATE_TIME,
                         locale: Locale = Locale.ENGLISH): String {
    if (this.isNotBlank()) {
        var date: Date? = null
        try {
            date = SimpleDateFormat(currentFormat.toString(), locale).parse(this)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return SimpleDateFormat(requiredFormat.toString(), locale).format(date)
    } else {
        return ""
    }
}