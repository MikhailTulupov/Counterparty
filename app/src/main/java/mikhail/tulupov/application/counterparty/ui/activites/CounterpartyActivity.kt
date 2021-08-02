package mikhail.tulupov.application.counterparty.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.databinding.ActivityCounterpartyBinding

class CounterpartyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterpartyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_counterparty)

    }
}