package ru.example.ivan.ulikirostov



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.example.ivan.ulikirostov.databinding.FragmentItemInfoBinding
import ru.example.ivan.ulikirostov.databinding.FragmentMainBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ItemInfoFragment : Fragment() {

    private lateinit var binding: FragmentItemInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_info, container, false)
        var view = binding.root

        var item = arguments?.getSerializable("item") as Item
        binding.item = item
        binding.executePendingBindings()

        return view
    }


}