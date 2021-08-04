package mikhail.tulupov.application.counterparty.data.models

import android.graphics.Bitmap
import androidx.room.*
import mikhail.tulupov.application.counterparty.utilities.*
import java.util.*

@Entity(tableName = DATABASE_TABLE_NAME)
data class Counterparty(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID, typeAffinity = ColumnInfo.TEXT)
    var id: UUID = setId(),
    @ColumnInfo(name = COLUMN_NAME, typeAffinity = ColumnInfo.TEXT)
    var name: String = "",
    @ColumnInfo(name = COLUMN_PHONE_NUMBER, typeAffinity = ColumnInfo.TEXT)
    var phoneNumber: String = "",
    @ColumnInfo(name = COLUMN_EMAIL, typeAffinity = ColumnInfo.TEXT)
    var email: String = "",
    @ColumnInfo(name = COLUMN_AVATAR, typeAffinity = ColumnInfo.BLOB)
    var avatar: Bitmap? = null
) {
    constructor(name: String, phoneNumber: String, email: String) : this(
        id = setId(),
        name,
        phoneNumber,
        email,
        avatar = null
    )

    constructor(name: String, phoneNumber: String, email: String, avatar: Bitmap?) : this(
        id = setId(),
        name,
        phoneNumber,
        email,
        avatar
    )
}

private fun setId() = UUID.randomUUID()