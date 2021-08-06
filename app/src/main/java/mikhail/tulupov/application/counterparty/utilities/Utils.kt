package mikhail.tulupov.application.counterparty.utilities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*

object Utils {
    fun setId(): UUID = UUID.randomUUID()

    fun setDefaultAvatar(context: Context?): Bitmap? {
        val assetManager = context?.assets
        val inputStream = assetManager?.open("avatar_default.jpg")
        return BitmapFactory.decodeStream(inputStream)
    }
}