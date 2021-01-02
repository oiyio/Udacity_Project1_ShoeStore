package com.udacity.shoestore.shoedetail


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {

    var shoe = MutableLiveData<Shoe>().apply {
        value = Shoe()
    }
}