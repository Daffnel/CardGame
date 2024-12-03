package com.hfad.cardgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hfad.cardgame.CardsViewModel
import com.hfad.cardgame.databinding.FragmentCardsBinding


class CardsFragment : Fragment() {

    private lateinit var viewModel: CardsViewModel

    private var _binding: FragmentCardsBinding? = null
    private val binding get() = _binding!!

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

viewModel = ViewModelProvider(this)[CardsViewModel::class.java]
}





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cards, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val image: Int = R.drawable.ace_of_hearts

       //live  data to change imageview


        binding.ivCard.setImageResource(image)

        binding.btnLower.setOnClickListener {

            // Lägg till funktionalitet för btnLower här
            Toast.makeText(context, "Lower button clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnHigher.setOnClickListener {

            // Lägg till funktionalitet för btnHigher här
            Toast.makeText(context, "Higher button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null

    }

}