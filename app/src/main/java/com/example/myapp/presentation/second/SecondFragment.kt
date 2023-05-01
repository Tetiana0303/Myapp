package com.example.myapp.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapp.databinding.FragmentSecondBinding

class SecondFragment() : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var secondViewModel: SecondViewModel


    companion object {
        const val numberInArray = "number"
        const val name = "name"
        const val fullDesc = "fullDesk"
        const val url = "url"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.tvPhoto)
        binding.tvName.text = arguments?.getString(name)
        binding.tvFullDesc.text = arguments?.getString(fullDesc)
        secondViewModel.getFact()

        secondViewModel.myFactFromApi.observe(viewLifecycleOwner) {
            binding.tvFactOfRandCat.text = it
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}