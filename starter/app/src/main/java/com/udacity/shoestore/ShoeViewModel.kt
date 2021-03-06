package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel(){

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addShoe(shoe : Shoe) {
       val mylist =  _shoeList.value?.toMutableList() ?: mutableListOf()
        mylist.add(shoe)
        _shoeList.value = mylist
    }
}