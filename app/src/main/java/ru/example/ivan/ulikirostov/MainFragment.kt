package ru.example.ivan.ulikirostov


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.example.ivan.ulikirostov.databinding.FragmentMainBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment(), MainRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentMainBinding
    private var mainRecyclerViewAdapter = MainRecyclerViewAdapter(arrayListOf(), this)
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = activity?.let { it -> ViewModelProviders.of(it).get(MainViewModel::class.java) }
        recyclerView = context?.let { RecyclerView(it) }!!

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        var view = binding.root

        binding.viewModel = viewModel
        binding.executePendingBindings()

        viewModel!!.items.observe(this,
            Observer<ArrayList<Item>> { it?.let{ mainRecyclerViewAdapter.replaceData(it)} })


        binding.mainRv.layoutManager = LinearLayoutManager(activity)
        binding.mainRv.adapter = mainRecyclerViewAdapter

        var floatingActionButton = view.findViewById<FloatingActionButton>(R.id.main_fab)
        floatingActionButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_resultFragment)
        }

        return view
    }

    override fun onItemClick(position: Int) {
        val viewModel = activity?.let { it -> ViewModelProviders.of(it).get(MainViewModel::class.java) }
        var bundle = Bundle()
        bundle.putSerializable("item", viewModel?.getItemByPosition(position))
        NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_itemInfoFragment, bundle)
    }


}