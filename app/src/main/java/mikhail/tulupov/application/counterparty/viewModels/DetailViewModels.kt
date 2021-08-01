package mikhail.tulupov.application.counterparty.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.data.repositories.CounterpartyRepository
import java.util.*

class DetailViewModels(application: Application): AndroidViewModel(application) {

    private val repository = CounterpartyRepository.getInstance(application)

    fun getCounterpartyById(id: UUID): LiveData<Counterparty> =
        MutableLiveData(repository.getCounterpartyById(id))

    fun deleteCounterparty(counterparty: Counterparty): Unit =
        repository.deleteCounterparty(counterparty)

    fun updateCounterparty(counterparty: Counterparty): Unit =
        repository.updateCounterparty(counterparty)

    fun insertCounterparty(counterparty: Counterparty): Unit =
        repository.addCounterparty(counterparty)
}