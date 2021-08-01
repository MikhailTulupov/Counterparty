package mikhail.tulupov.application.counterparty.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import mikhail.tulupov.application.counterparty.data.models.Counterparty
import mikhail.tulupov.application.counterparty.data.repositories.CounterpartyRepository

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CounterpartyRepository.getInstance(application.applicationContext)

    private val counterpartyListLiveData: MutableLiveData<List<Counterparty>> =
        MutableLiveData(repository.getAllCounterparty())

    fun getListLiveDataCounterparty() = counterpartyListLiveData
}