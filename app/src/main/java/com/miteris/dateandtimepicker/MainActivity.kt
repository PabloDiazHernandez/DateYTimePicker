package com.miteris.dateandtimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Month

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDate.setOnClickListener { showDatePickerDialog() }
        etTime.setOnClickListener { showTimePickerDialog() }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { time -> onTimeSelected(time) }
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTime.setText("Seleccionaste las: $time")
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{ day, month, year -> onDateSelected(day, month, year)  }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year:Int){
    etDate.setText("$day/${month+1}/$year")
    }
}