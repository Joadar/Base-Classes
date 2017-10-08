package io.smallant.baseclasses.others

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by Jonathan on 08/09/2017.
 */
abstract class BaseWebViewClient(val context: Activity) : WebViewClient() {

    abstract fun handleUrl(url: String)
    abstract fun onPageFinished(view: View)

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        manageUrl(url)
        return true
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        manageUrl(request.url.toString())
        return true
    }

    override fun onPageFinished(view: WebView, url: String) {
        val javascript = "javascript:" +
                "var iframes = document.getElementsByTagName('iframe');" +
                "for (var i = 0, l = iframes.length; i < l; i++) {" +
                "   var iframe = iframes[i]," +
                "   a = document.createElement('a');" +
                "   a.setAttribute('href', iframe.src);" +
                "   d = document.createElement('div');" +
                "   d.style.width = iframe.offsetWidth + 'px';" +
                "   d.style.height = iframe.offsetHeight + 'px';" +
                "   d.style.top = iframe.offsetTop + 'px';" +
                "   d.style.left = iframe.offsetLeft + 'px';" +
                "   d.style.position = 'absolute';" +
                "   d.style.opacity = '0';" +
                "   d.style.filter = 'alpha(opacity=0)';" +
                "   d.style.background = 'black';" +
                "   a.appendChild(d);" +
                "   iframe.offsetParent.appendChild(a);" +
                "}"
        view.loadUrl(javascript)

        onPageFinished(view)

        super.onPageFinished(view, url)
    }

    private fun manageUrl(url: String) {
        handleUrl(url)
    }
}