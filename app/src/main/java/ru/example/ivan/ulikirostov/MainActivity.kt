package ru.example.ivan.ulikirostov

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setIcon(R.drawable.logo_small)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.sp = getSharedPreferences(viewModel.APP_PREF, Context.MODE_PRIVATE)

        if (viewModel.sp.contains(viewModel.APP_PREF_TOP_TEXT)){
            viewModel.topText.set(viewModel.sp.getString(viewModel.APP_PREF_TOP_TEXT, ""))
        }
        if (viewModel.sp.contains(viewModel.APP_PREF_BOTTOM_TEXT)){
            viewModel.bottomText.set(viewModel.sp.getString(viewModel.APP_PREF_BOTTOM_TEXT, ""))
        }
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
                Navigation.findNavController(this, R.id.fr_container).navigate(R.id.infoFragment)
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
            R.id.action_settings -> {
                Navigation.findNavController(this, R.id.fr_container).navigate(R.id.settingsFragment)
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
