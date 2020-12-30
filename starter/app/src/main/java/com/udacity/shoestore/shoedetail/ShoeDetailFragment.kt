package com.udacity.shoestore.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.buttonSave.setOnClickListener(
            // save to viewmodel
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        return binding.root
    }
}