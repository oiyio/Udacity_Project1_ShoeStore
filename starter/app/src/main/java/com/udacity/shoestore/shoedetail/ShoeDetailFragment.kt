package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    val sharedViewModel: ShoeViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.buttonSave.setOnClickListener {
            if (binding.editTextShoeSize.text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Size field is empty. Please choose a valid size.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            sharedViewModel.addShoe(viewModel.shoe.value!!)
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.shoeListFragment) }
        }

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        return binding.root
    }
}