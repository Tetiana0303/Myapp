package com.example.myapp.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.data.Animal
import com.example.myapp.R
import com.example.myapp.databinding.FragmentFirstBinding
import com.example.myapp.presentation.second.SecondFragment

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var animals = ArrayList<Animal>()
    lateinit var adapter: FirstAdapterOfAnimal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var Murka = Animal("Murka", getString(R.string.fullDescMurka),"Cat", getString(R.string.urlMurka))
        var Rosa = Animal("Rosa", getString(R.string.fullDescRosa),"Cat", getString(R.string.urlRosa))
        var Matilda =Animal("Matilda", getString(R.string.fullDescMatilda),"Cat", getString(R.string.urlMatilda))
        var Naomi = Animal("Naomi", getString(R.string.fullDescNaomi),"Cat", getString(R.string.urlNaomi))

        animals.add(Murka)
        animals.add(Rosa)
        animals.add(Matilda)
        animals.add(Naomi)

        adapter = FirstAdapterOfAnimal{ itemView ->
            val bundle = bundleOf(
                SecondFragment.numberInArray to itemView,
                SecondFragment.name to animals.get(itemView).name,
                SecondFragment.fullDesc to animals.get(itemView).fullDesc,
                SecondFragment.url to animals.get(itemView).urlPhoto
            )


            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
        adapter.setArrayListOfAnimals(animals)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}