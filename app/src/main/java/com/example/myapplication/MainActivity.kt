package com.example.myapplication

import android.app.ActionBar
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sliderValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

    private fun showResult(){
        val dialogTitle = getString(R.string.result_dialog_title)
        val dialogMessage = getString(R.string.result_dialog_message, sliderValue)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.setPositiveButton(R.string.result_dialog_button_text) {dialog, _->
            dialog.dismiss()
        }

        builder.create().show()
    }
}

