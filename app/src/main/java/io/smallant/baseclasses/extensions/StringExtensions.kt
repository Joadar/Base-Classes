package io.smallant.baseclasses.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Jonathan on 07/09/2017.
 */

fun String.convertDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE)
    val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE)
    return outputFormat.format(inputFormat.parse(this))
}


@SuppressWarnings("deprecation")
fun String.convertFromHtml(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        return Html.fromHtml(this)
    }
}

@SuppressWarnings("deprecation")
fun String.convertResFromHtml(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        return Html.fromHtml(this)
    }
}