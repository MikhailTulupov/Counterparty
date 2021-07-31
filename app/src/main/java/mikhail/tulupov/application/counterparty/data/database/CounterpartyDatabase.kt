package mikhail.tulupov.application.counterparty.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.utilities.Converters
import mikhail.tulupov.application.counterparty.utilities.DATABASE_NAME

@Database(entities = [Counterparty::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CounterpartyDatabase : RoomDatabase() {

    abstract fun counterpartyDao(): CounterpartyDao

    companion object {
        private var instance: CounterpartyDatabase? = null

        fun getInstance(context: Context): CounterpartyDatabase = instance ?: kotlin.run {
            instance =
                Room.databaseBuilder(context, CounterpartyDatabase::class.java, DATABASE_NAME)
                    .build()
            instance!!
        }


    }
}