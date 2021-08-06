package mikhail.tulupov.application.counterparty.viewModels

import android.app.Application
import androidx.lifecycle.*
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.data.repositories.CounterpartyRepository

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CounterpartyRepository.getInstance(application)

    val allCounterparty: LiveData<List<Counterparty>> = repository.getAllCounterparty().asLiveData()

}
