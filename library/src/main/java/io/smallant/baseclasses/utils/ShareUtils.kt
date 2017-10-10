package io.smallant.baseclasses.utils

import android.content.Context
import android.content.Intent
import io.smallant.baseclasses.R

/**
 * Created by Jonathan on 10/10/2017.
 */
object ShareUtils {
    private val intent = Intent()
    private lateinit var context: Context

    fun share(context: Context, value: String) {
        this.context = context
        intent.putExtra(Intent.EXTRA_TEXT, value)
        share()
    }

    private fun share() {
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        context.startActivity(Intent.createChooser(intent, context.resources.getText(R.string.share_with)))
    }
}