package com.hfad.cardgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.cardgame.databinding.FragmentStatsBinding
import android.net.Uri

class StatsFragment : Fragment() {



    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stats, container, false)

        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }


}