package mikhail.tulupov.application.counterparty.data.models

import android.graphics.Bitmap
import androidx.room.*
import mikhail.tulupov.application.counterparty.utilities.*
import mikhail.tulupov.application.counterparty.utilities.Utils.setId
import java.util.*

@Entity(tableName = DATABASE_TABLE_NAME)
data class Counterparty(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID, typeAffinity = ColumnInfo.TEXT)
    var id: UUID = setId(),
    @ColumnInfo(name = COLUMN_NAME, typeAffinity = ColumnInfo.TEXT)
    var name: String,
    @ColumnInfo(name = COLUMN_PHONE_NUMBER, typeAffinity = ColumnInfo.TEXT)
    var phoneNumber: String,
    @ColumnInfo(name = COLUMN_EMAIL, typeAffinity = ColumnInfo.TEXT)
    var email: String? = null,
    @ColumnInfo(name = COLUMN_AVATAR, typeAffinity = ColumnInfo.BLOB)
    var avatar: Bitmap? = null
) {

    object CounterpartyFactory {

        fun makeCounterparty(name: String, phoneNumber: String) = Counterparty(
            id = setId(),
            name,
            phoneNumber,
            email = "",
            avatar = null
        )

        fun makeCounterparty(name: String, phoneNumber: String, email: String?) = Counterparty(
            id = setId(),
            name,
            phoneNumber,
            email,
            avatar = null
        )

        fun makeCounterparty(name: String, phoneNumber: String, email: String?, avatar: Bitmap?) =
            Counterparty(
                id = setId(),
                name,
                phoneNumber,
                email,
                avatar
            )

        fun makeCounterparty(avatar: Bitmap?) = Counterparty(
            id = setId(),
            name = "",
            phoneNumber = "",
            email = "",
            avatar
        )
    }
}