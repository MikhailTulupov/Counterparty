package mikhail.tulupov.application.counterparty.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.utilities.DATABASE_TABLE_NAME
import java.util.*

@Dao
interface CounterpartyDao {

    @Query("SELECT * FROM $DATABASE_TABLE_NAME")
    fun getAllCounterparty(): Flow<List<Counterparty>>

    @Query("SELECT * FROM counterparty WHERE id = :id")
    fun getCounterpartyById(id: UUID): Flow<Counterparty>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCounterparty(counterparty: Counterparty)

    @Update
    suspend fun updateCounterparty(counterparty: Counterparty)

    @Delete
    suspend fun deleteCounterparty(counterparty: Counterparty): Int

}