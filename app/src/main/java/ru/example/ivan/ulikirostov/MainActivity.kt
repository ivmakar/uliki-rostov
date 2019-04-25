package ru.example.ivan.ulikirostov

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        when (item!!.itemId){
            R.id.action_clear -> {
                viewModel.clearAll()
                Navigation.findNavController(this, R.id.fr_container).popBackStack()
                true
            }
            R.id.action_details -> {
                Navigation.findNavController(this, R.id.fr_container).navigate(R.id.action_mainFragment_to_infoFragment)
                true
            }
            R.id.action_share -> {
                viewModel.calculatePrice()
                var shareText = viewModel?.shareData()
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }
                startActivity(shareIntent)
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
