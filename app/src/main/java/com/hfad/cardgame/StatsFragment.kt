package com.hfad.cardgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.Navigation
import com.hfad.cardgame.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root

    //return inflater.inflate(R.layout.fragment_stats, container, false)

    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.btnHome.setOnClickListener {

        Navigation.findNavController(it).navigate(R.id.action_statsFragment_to_cardsFragment)
    }
        }

    }
