package com.foodtracker.app.presentation.analytics

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentAnalyticsBinding
import com.foodtracker.app.domain.model.DailyProgress
import com.github.mikephil.charting.data.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    private lateinit var binding: FragmentAnalyticsBinding
    private val viewModel by viewModel<AnalyticsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAnalyticsBinding.inflate(inflater, container, false)

        lateinit var datePoints: List<String>
//        viewModel.getDailyProgresses()
//        viewModel.responseDailyProgresses.observe(viewLifecycleOwner) { responseDailyProgresses ->
//            if (responseDailyProgresses != null) {
//                datePoints = responseDailyProgresses.map {convertLongToDate(it!!.date)}
//                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
//            }
//        }
        setupChart()
        val entries = mutableListOf<BarEntry>()

        // Create your list of data points (assuming your data is in a List<Float>)


        // Convert the data points to BarEntry objects for the chart
        val dataPoints = listOf(2020f, 2400f, 2140f, 2230f, 1928f, 2020f, 2400f, 2140f, 2230f, 1928f, 2020f, 2400f, 2140f, 2230f, 1928f)
        dataPoints.forEachIndexed { index, value ->
            entries.add(BarEntry(index.toFloat(), value))
        }

        // Create a dataset with the entries
        val dataSet = BarDataSet(entries, "Chart Data")

        // Customize the appearance of the dataset
        dataSet.color = Color.GREEN

        // Create a BarData object with the dataset
        val barData = BarData(dataSet)

        // Set the BarData to the chart
        binding.chart.data = barData

        // Refresh the chart
        binding.chart.invalidate()
//        populateChartData()
        return binding.root
    }

    private fun setupChart() {
        // Customize the appearance of the chart
        binding.chart.description.isEnabled = false
        binding.chart.setDrawGridBackground(false)
        binding.chart.legend.isEnabled = false
    }

//    private fun populateChartData() {
//        val entries = mutableListOf<BarEntry>()
//
//        // Create your list of data points (assuming your data is in a List<Float>)
//        val dataPoints = listOf(10f, 15f, 20f, 25f, 30f)
//
//        // Convert the data points to BarEntry objects for the chart
//        dataPoints.forEachIndexed { index, value ->
//            entries.add(BarEntry(index.toFloat(), value))
//        }
//
//        // Create a dataset with the entries
//        val dataSet = BarDataSet(entries, "Chart Data")
//
//        // Customize the appearance of the dataset
//        dataSet.color = Color.GREEN
//
//        // Create a BarData object with the dataset
//        val barData = BarData(dataSet)
//
//        // Set the BarData to the chart
//        binding.chart.data = barData
//
//        // Refresh the chart
//        binding.chart.invalidate()
//    }

    private fun convertLongToDate(longDate: Long): String {
        val date = Date(longDate)
        val calendar = Calendar.getInstance()
        calendar.time = date

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1  // Месяцы в Calendar начинаются с 0

        // Преобразование чисел дня и месяца в строку с двузначным форматом
        val formattedDay = String.format("%02d", day)
        val formattedMonth = String.format("%02d", month)

        // Соединение числа дня и месяца в строку
        return "$formattedDay/$formattedMonth"
    }

}