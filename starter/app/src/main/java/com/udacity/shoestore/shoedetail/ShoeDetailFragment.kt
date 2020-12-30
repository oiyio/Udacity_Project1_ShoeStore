package com.udacity.shoestore.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.buttonSave.setOnClickListener {
            // save to viewmodel
            val shoe = Shoe(
                name = binding.editTextShoeName.text.toString(),
                size = binding.editTextShoeSize.text.toString().toDouble(),
                company = binding.editTextCompany.text.toString(),
                description = binding.editTextDescription.text.toString()
            )

            sharedViewModel.addShoe(shoe)
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.shoeListFragment) }
        }

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        return binding.root
    }
}