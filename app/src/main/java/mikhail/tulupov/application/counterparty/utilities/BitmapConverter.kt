package mikhail.tulupov.application.counterparty.utilities

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.InverseMethod

object BitmapConverter {
    @InverseMethod("bitmapToDrawable")
    @JvmStatic
    fun bitmapToDrawable(value: Bitmap?): BitmapDrawable? {
        return value?.toDrawable(Resources.getSystem())
    }
}