package ru.example.ivan.ulikirostov


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import ru.example.ivan.ulikirostov.databinding.FragmentSettingsBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: FragmentSettingsBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class SettingsFragment : Fragment() {

    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = activity?.let { it -> ViewModelProviders.of(it).get(MainViewModel::class.java) }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        var view = binding.root

        binding.viewModel = viewModel
        binding.executePendingBindings()

        saveButton = view.findViewById(R.id.save_button)
        saveButton.setOnClickListener {

            val editor = viewModel!!.sp.edit()
            editor.putString(viewModel.APP_PREF_BOTTOM_TEXT, viewModel.bottomText.get())
            editor.putString(viewModel.APP_PREF_TOP_TEXT, viewModel.topText.get())
            editor.apply()
            NavHostFragment.findNavController(this).popBackStack()
        }

        return view
    }


}
