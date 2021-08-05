package mikhail.tulupov.application.counterparty.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import mikhail.tulupov.application.counterparty.R
import mikhail.tulupov.application.counterparty.databinding.ActivityCounterpartyBinding

class CounterpartyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterpartyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_counterparty)

        // find navHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
        val navController = navHostFragment?.findNavController()
        // setup action bar
        NavigationUI.setupActionBarWithNavController(this, navController!!)

    }

    override fun onSupportNavigateUp(): Boolean {
        super.onSupportNavigateUp()
        val navController = this.findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp()
    }
}