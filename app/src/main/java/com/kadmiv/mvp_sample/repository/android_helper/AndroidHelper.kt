package com.kadmiv.mvp_sample.repository.android_helper

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Kadmiv on 01.11.2020 12:21
 */

abstract class AbstractAndroidHelper {
    abstract fun copyToClipBoard(bufferedText: String)
    abstract fun hasConnection(): Boolean
}

class AndroidHelper(val context: Context) : AbstractAndroidHelper() {
    var LOG: Logger = LoggerFactory.getLogger(AndroidHelper::class.java)

    // Copy EditCopy text to the ClipBoard
    override fun copyToClipBoard(bufferedText: String) {
        LOG.debug("")
        val sdk = Build.VERSION.SDK_INT
        if (sdk < Build.VERSION_CODES.HONEYCOMB) {
            val clipboard =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager
            clipboard.text = bufferedText
        } else {
            try {
                var clipboard =
                    context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = android.content.ClipData.newPlainText(bufferedText, bufferedText)
                clipboard.setPrimaryClip(clip)
            } catch (ex: java.lang.Exception) {
                LOG.error("", ex)
            }
        }
    }

    override fun hasConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo: NetworkInfo? = cm.activeNetworkInfo
        val answer = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        LOG.debug("$answer")
        return answer
    }

}