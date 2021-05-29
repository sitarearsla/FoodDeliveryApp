package com.example.fooddeliveryapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentAnasayfaBinding
import com.example.fooddeliveryapp.databinding.FragmentYemekDetayBinding
import com.example.fooddeliveryapp.viewModel.AnasayfaFragmentViewModel

class YemekDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false)
        // Inflate the layout for this fragment
        tasarim.anasayfaToolbarBaslik = "Yemekler"
        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek=bundle.yemekNesnesi
        tasarim.yemekNesnesi=gelenYemek
        return tasarim.root
    }


}