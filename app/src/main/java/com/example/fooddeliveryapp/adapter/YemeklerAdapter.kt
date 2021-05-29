package com.example.fooddeliveryapp.adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.SatirCardBinding
import com.google.android.material.snackbar.Snackbar
import com.example.fooddeliveryapp.entity.Yemekler
import com.example.fooddeliveryapp.fragment.AnasayfaFragment
import com.squareup.picasso.Picasso
import com.example.fooddeliveryapp.fragment.AnasayfaFragmentDirections

class YemeklerAdapter(var mContext:Context,
                      var yemeklerListe:List<Yemekler>) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>()  {


    inner class CardTasarimTutucu(satirCardBinding: SatirCardBinding)
        :RecyclerView.ViewHolder(satirCardBinding.root){

        var satirCardBinding: SatirCardBinding

        init {
            this.satirCardBinding = satirCardBinding
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SatirCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        Log.e("adasdsad", "denememememe")
        val yemek = yemeklerListe.get(position)
        val holder = holder.satirCardBinding

        holder.yemekNesnesi = yemek
        Log.e("yemek", yemek.toString())


    }

    override fun getItemCount(): Int {
        return yemeklerListe.size
    }

    fun yemekDetayGecis(it : View, yemek: Yemekler){
        val gecis = AnasayfaFragmentDirections.yemekDetayaGecis(yemek)
        Navigation.findNavController(it).navigate(gecis)
    }

}


@BindingAdapter("load_image")
fun setImageViewResource(imageView: ImageView, yemek_resim_adi: String) {
    val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek_resim_adi}"
    Picasso.get().load(url)
        .placeholder(R.drawable.yemek_placeholder)
        .error(R.drawable.yemek_placeholder)
        .into(imageView)
}

@BindingAdapter("unicode")
fun setUnicode(textView: TextView, urun_fiyat: Double) {
    textView.text = "${urun_fiyat} \u20BA"
}