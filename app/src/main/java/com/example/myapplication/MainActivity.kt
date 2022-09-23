package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var sliderValue = 0
    private var targetValue = Random.nextInt(1, 100)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.targetTextView.text = targetValue.toString()

        binding.hitMeButton.setOnClickListener {
            Log.i("Button Click Listener",
                 "You Clicked on ME!")
            showResult()
        }



        binding.tagetValueNumber.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser:  Boolean) {
                sliderValue = progress

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun score(sliderValueGuess: Int): Int{
        val maxScore = 100
        var difference = abs(targetValue - sliderValue)
        println(difference)
        return maxScore - difference
    }

    private fun showResult(){

        if ( sliderValue == targetValue ) {
            val dialogTitle = getString(R.string.result_dialog_title_right)
            val dialogMessage = getString(R.string.result_dialog_message_right, score(sliderValue))

            val builder = AlertDialog.Builder(this)
            builder.setTitle(dialogTitle)
            builder.setMessage(dialogMessage)
            builder.setPositiveButton(R.string.result_dialog_button_text_right) { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }else{
            val dialogTitle = getString(R.string.result_dialog_title_wrong)
            val dialogMessage = getString(R.string.result_dialog_message_wrong, sliderValue, score(sliderValue))

            val builder = AlertDialog.Builder(this)
            builder.setTitle(dialogTitle)
            builder.setMessage(dialogMessage)
            builder.setPositiveButton(R.string.result_dialog_button_text_wrong) { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }

    }
}

