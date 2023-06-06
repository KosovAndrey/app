package com.foodtracker.app.presentation.getstarted.birthday

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentBirthdayBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


class BirthdayFragment : Fragment(R.layout.fragment_birthday) {
    private val viewModel by viewModel<BirthdayViewModel>()
    private lateinit var binding: FragmentBirthdayBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBirthdayBinding.bind(view)
        binding.button.setOnClickListener {
//            val user = requireArguments().getParcelable<UserGetStartedModel>("user")
//            //user?.birthDay = binding.datePicker.dayOfMonth * DAY + binding.datePicker.month * MONTH + binding.datePicker.year * YEAR
//            user?.birthDay = binding.datePicker.dayOfMonth
//            user?.birthMonth = 2//binding.datePicker.month
//            user?.birthYear = binding.datePicker.year

//            val text =
//                "${binding.datePicker.dayOfMonth}-${binding.datePicker.month}-${binding.datePicker.year}"
//
//            val unix = LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
//                .atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
//            viewModel.setBirthday("unix")
            findNavController().navigate(R.id.action_birthdayFragment_to_heightFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this.requireContext(),
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)
                val selectedDateInMillis = selectedCalendar.timeInMillis

                // Используйте выбранную дату в формате Long
                // Например, сохраните ее в переменную или передайте в другую функцию
                // selectedDateInMillis - это значение даты в миллисекундах с начала эпохи
                viewModel.setBirthday(selectedDateInMillis.toString())// переделать на long
            },
            year,
            month,
            day)
    }
//    companion object {
//        const val DAY = 86400
//        const val MONTH = 2629743
//        const val YEAR = 31556926
//    }
}