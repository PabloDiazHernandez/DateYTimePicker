package com.miteris.dateandtimepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(val listener: (day:Int, month:Int, year:Int) -> Unit):DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context, this, year, month, day)

        // Permitir elegir 1 mes atrás
        //c.add(Calendar.MONTH, -1)
        //picker.datePicker.minDate = c.timeInMillis

        // Permitir 3 días mas del mes
        //c.add(Calendar.DAY_OF_MONTH, 3)
        //picker.datePicker.maxDate = c.timeInMillis


        return picker
    }
}