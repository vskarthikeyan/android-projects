package com.example.artbooktesting.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.example.artbooktesting.R
import com.example.artbooktesting.databinding.FragmentArtDetailsBinding
import com.example.artbooktesting.util.Status
import com.example.artbooktesting.viewmodel.ArtViewModel
import javax.inject.Inject

class ArtDetailsFragment @Inject constructor(
    val glide: RequestManager
): Fragment(R.layout.fragment_art_details) {

    lateinit var viewModel: ArtViewModel

    private var fragmentBinding : FragmentArtDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ArtViewModel::class.java]

        val binding = FragmentArtDetailsBinding.bind(view)
        fragmentBinding = binding

        subscribeToObservers()

        binding.artImageView.setOnClickListener {
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageApiFragment())
        }

        val callback = object:OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }

        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

        binding.saveButton.setOnClickListener {
            viewModel.makeArt(
                binding.enterName.text.toString(),
                binding.enterArtistName.text.toString(),
                binding.enterYear.text.toString())
        }

    }

    private fun subscribeToObservers(){
        viewModel.selectedImageURL.observe(viewLifecycleOwner, Observer { url->
            println(url)
            fragmentBinding?.let {
                glide.load(url).into(it.artImageView)
            }
        })

        viewModel.insertArtMessage.observe(viewLifecycleOwner, Observer {
           when(it.status) {
               Status.SUCCESS -> {
                   Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
                   findNavController().popBackStack()
                   viewModel.resetInsertMsg()
               }
               Status.ERROR -> {
                   Toast.makeText(requireContext(), it.message?: "Error", Toast.LENGTH_LONG).show()
               }
               Status.LOADING -> {

               }
           }
        })
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

}