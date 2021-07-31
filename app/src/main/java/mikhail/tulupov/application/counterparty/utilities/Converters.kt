package mikhail.tulupov.application.counterparty.utilities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.util.*


class Converters {

    @TypeConverter
    fun fromId(id: UUID) = id.toString()

    @TypeConverter
    fun toId(id: String) = UUID.fromString(id)

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        return baos.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap =
        BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
}