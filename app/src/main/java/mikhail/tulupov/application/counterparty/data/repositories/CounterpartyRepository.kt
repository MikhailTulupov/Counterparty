package mikhail.tulupov.application.counterparty.data.repositories

import android.app.Application
import android.content.Context
import mikhail.tulupov.application.counterparty.data.database.CounterpartyDatabase
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import java.util.*

class CounterpartyRepository private constructor(context: Context) {

    private val counterpartyDao =
        CounterpartyDatabase.getInstance(context).counterpartyDao()

    fun getAllCounterparty() = counterpartyDao.getAllCounterparty()

    fun getCounterpartyById(id: UUID) = counterpartyDao.getCounterpartyById(id)

    fun addCounterparty(counterparty: Counterparty) =
        counterpartyDao.insertCounterparty(counterparty)

    fun updateCounterparty(counterparty: Counterparty) =
        counterpartyDao.updateCounterparty(counterparty)

    fun deleteCounterparty(counterparty: Counterparty) =
        counterpartyDao.deleteCounterparty(counterparty)

    companion object {
        private var instance: CounterpartyRepository? = null

        fun getInstance(context: Context) = instance ?: kotlin.run {
            instance = CounterpartyRepository(context)
            instance!!
        }
    }
}