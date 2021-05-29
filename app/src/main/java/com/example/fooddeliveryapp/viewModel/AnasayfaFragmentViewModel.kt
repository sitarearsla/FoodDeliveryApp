package com.example.fooddeliveryapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.entity.Yemekler
import com.example.fooddeliveryapp.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val ydaor = YemeklerDaoRepository()

    init {
        yemekleriYukle()
        yemeklerListesi = ydaor.yemekleriGetir()

    }

    fun yemekleriYukle() {
        ydaor.tumYemeklerAl()
    }

}