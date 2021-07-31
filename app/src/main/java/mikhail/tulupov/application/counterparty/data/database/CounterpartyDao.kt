package mikhail.tulupov.application.counterparty.data.database

import androidx.room.*
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.utilities.DATABASE_TABLE_NAME
import java.util.*

@Dao
interface CounterpartyDao {

    @Query("SELECT * FROM $DATABASE_TABLE_NAME")
    fun getAllCounterparty(): List<Counterparty>

    @Query("SELECT * FROM counterparty WHERE id = :id")
    fun getCounterpartyById(id: UUID): Counterparty

    @Insert
    fun insertCounterparty(counterparty: Counterparty)

    @Update
    fun updateCounterparty(counterparty: Counterparty)

    @Delete
    fun deleteCounterparty(counterparty: Counterparty)

}