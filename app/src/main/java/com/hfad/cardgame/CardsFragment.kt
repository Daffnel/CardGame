package com.hfad.cardgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
    ): View {

        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cards, container, false)

    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.showCard()

       // Live data for card image
       viewModel.currentCard.observe(viewLifecycleOwner, Observer { cardResId ->
           cardResId?.let {
               binding.ivCard.setImageResource(it)
                          }
       })
        // Live data for image right or wrong answer
        viewModel.answerImage.observe(viewLifecycleOwner, Observer { cardResId ->
            cardResId?.let {
                binding.ivRightOrWrongAnswer.setImageResource(it)

            }
        })

        //live data for text displaying right or wrong answer
        viewModel.answerText.observe(viewLifecycleOwner, Observer { newText ->
            newText?.let {
                binding.tvAnswer.text = it

            }
        })
        //Live Data for number of guesses
        viewModel.noOfGuesses.observe(viewLifecycleOwner, Observer { noOfGuesses ->
            noOfGuesses?.let {
                binding.tvNoOfGuesses.text = "Number of guesses: $it"

            }
        })

        // Live data for number of correct answers
        viewModel.noCorrectGuesses.observe(viewLifecycleOwner, Observer { noOfCorrectGuesses ->
            noOfCorrectGuesses?.let {
                binding.tvNoOfCorrectGuesses.text = "Correct guesses: $it"

            }
        })

        //Live data for number of incorrect answers
        viewModel.noIncorrectGuesses.observe(viewLifecycleOwner, Observer { noOfIncorrectGuesses ->
            noOfIncorrectGuesses?.let {
                binding.tvNoIncorrectGuesses.text = "Incorrect guesses: $it"
            }
        })


        //Buttons for guessing
        binding.btnLower.setOnClickListener {

            viewModel.buttonLow()
        }

        binding.btnHigher.setOnClickListener {

            viewModel.buttonHigh()
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null

    }

}