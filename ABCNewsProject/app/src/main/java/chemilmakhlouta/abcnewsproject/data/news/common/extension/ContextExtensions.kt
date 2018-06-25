package chemilmakhlouta.abcnewsproject.data.news.common.extension

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import chemilmakhlouta.abcnewsproject.R

/**
 * Created by Chemil Makhlouta on 26/6/18.
 */
fun Context.navigateToExternalUrl(url: String) =
        CustomTabsIntent.Builder()
                .setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .build()
                .launchUrl(this, Uri.parse(url))