package ru.example.ivan.ulikirostov

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.example.ivan.ulikirostov.databinding.FragmentResultBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ResultFragment : Fragment(), ResultRecyclerViewAdapter.OnItemClickListener {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentResultBinding
    private var resultRecyclerViewAdapter = ResultRecyclerViewAdapter(arrayListOf(), this)
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = activity?.let { it -> ViewModelProviders.of(it).get(MainViewModel::class.java) }

        recyclerView = context?.let { RecyclerView(it) }!!

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        var view = binding.root

        binding.viewModel = viewModel
        binding.executePendingBindings()

/*        viewModel.items.observe(this,
            Observer<ArrayList<Item>> { it?.let{ mainRecyclerViewAdapter.replaceData(it)} })
*/
        viewModel?.calculatePrice()
        viewModel?.selrctedItems?.let { resultRecyclerViewAdapter.replaceData(it) }

        binding.mainRv.layoutManager = LinearLayoutManager(activity)
        binding.mainRv.adapter = resultRecyclerViewAdapter

        var shareButton = view.findViewById<Button>(R.id.button)
        shareButton.setOnClickListener {
            var shareText = viewModel?.shareData()
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(shareIntent)
        }

        return view
    }

    override fun onItemClick(position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
