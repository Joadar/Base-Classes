package io.smallant.baseclasses.extensions

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by jpannetier on 23/08/2017.
 */

fun Context.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, length).show()

fun View.visible() {
    if (!this.isVisible())
        visibility = View.VISIBLE
}

fun View.invisible() {
    if (!this.isInvisible())
        visibility = View.INVISIBLE
}

fun View.gone() {
    if (!this.isGone())
        visibility = View.GONE
}

fun View.isVisible() = visibility == View.VISIBLE
fun View.isInvisible() = visibility == View.INVISIBLE
fun View.isGone() = visibility == View.GONE

fun ImageView.loadImage(url: String?) {
    val options = RequestOptions().centerCrop()
    Glide.with(context)
            .load(url)
            .apply(options)
            .into(this)
}

fun ImageView.loadImage(resource: Int) {
    val options = RequestOptions().centerCrop()
    Glide.with(context)
            .load(resource)
            .apply(options)
            .into(this)
}


inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }
