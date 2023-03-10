package com.miteris.dateandtimepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment(val listener:(String) -> Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(activity as Context, this, hour, minutes, true)
        return dialog
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minutes: Int) {
        listener("$hour:$minutes")
    }
}