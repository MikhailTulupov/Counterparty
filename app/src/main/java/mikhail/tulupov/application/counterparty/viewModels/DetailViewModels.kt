package mikhail.tulupov.application.counterparty.viewModels

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.data.repositories.CounterpartyRepository
import java.util.*

class DetailViewModels(application: Application): AndroidViewModel(application) {

    private val repository = CounterpartyRepository.getInstance(application)

    fun addCounterparty(counterparty: Counterparty) = viewModelScope.launch {
        repository.addCounterparty(counterparty)
    }

    fun updateCounterparty(counterparty: Counterparty) = viewModelScope.launch {
        repository.updateCounterparty(counterparty)
    }

    fun deleteCounterparty(counterparty: Counterparty) = viewModelScope.launch {
        repository.deleteCounterparty(counterparty)
    }

    fun getCounterpartyById(id: UUID) = repository.getCounterpartyById(id).asLiveData()
}