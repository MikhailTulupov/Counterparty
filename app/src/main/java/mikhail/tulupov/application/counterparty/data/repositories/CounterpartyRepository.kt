package mikhail.tulupov.application.counterparty.data.repositories

import android.content.Context
import mikhail.tulupov.application.counterparty.data.database.CounterpartyDatabase
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import java.util.*

class CounterpartyRepository private constructor(context: Context) {

    private val counterpartyDao =
        CounterpartyDatabase.getDatabase(context).counterpartyDao()

    fun getAllCounterparty() = counterpartyDao.getAllCounterparty()

    fun getCounterpartyById(id: UUID) = counterpartyDao.getCounterpartyById(id)

    suspend fun addCounterparty(counterparty: Counterparty) =
        counterpartyDao.insertCounterparty(counterparty)

    suspend fun updateCounterparty(counterparty: Counterparty) =
        counterpartyDao.updateCounterparty(counterparty)

    suspend fun deleteCounterparty(counterparty: Counterparty) =
        counterpartyDao.deleteCounterparty(counterparty)

    companion object {
        private var instance: CounterpartyRepository? = null

        fun getInstance(context: Context) = instance ?: kotlin.run {
            instance = CounterpartyRepository(context)
            instance!!
        }
    }
}