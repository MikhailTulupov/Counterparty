package mikhail.tulupov.application.counterparty.viewModels

import android.app.Application
import androidx.lifecycle.*
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.ui.CounterpartyApplication

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = (application as CounterpartyApplication).repository

    val allCounterparty: LiveData<List<Counterparty>> = repository.getAllCounterparty().asLiveData()

}