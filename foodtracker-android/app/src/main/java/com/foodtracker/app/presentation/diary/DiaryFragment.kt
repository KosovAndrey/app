package com.foodtracker.app.presentation.diary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentDiaryBinding
import com.foodtracker.app.domain.model.DailyProgress
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class DiaryFragment : Fragment(R.layout.fragment_diary) {


    private lateinit var mList: MutableList<DataModel>
    private lateinit var adapter: ItemAdapter2

    private lateinit var binding: FragmentDiaryBinding
    private val viewModel by viewModel<DiaryViewModel>()

    //private var mAdapter = ItemAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)

        mList = ArrayList()

        adapter = ItemAdapter2(mList)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())



        binding.buttonProducts.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_productsFragment)
        }

        adapter.onAddProductClickListener = {
            //val bundle = Bundle()
            findNavController().navigate(R.id.action_diaryFragment_to_productsFragment)
        }

        //list1
        val nestedList1: MutableList<String> = java.util.ArrayList()
        nestedList1.add("Bread")
        nestedList1.add("Scrambled Eggs")
        nestedList1.add("Butter")
        nestedList1.add("Cheese")

        val nestedList2: MutableList<String> = java.util.ArrayList()
        nestedList2.add("Bread")
        nestedList2.add("Scrambled Eggs")
        nestedList2.add("Butter")
        nestedList2.add("Cheese")

        val nestedList3: MutableList<String> = java.util.ArrayList()
        nestedList3.add("Bread")
        nestedList3.add("Scrambled Eggs")
        nestedList3.add("Butter")
        nestedList3.add("Cheese")



        mList.add(DataModel(nestedList1, "Breakfast"))
        mList.add(DataModel(nestedList2, "Lunch"))
        mList.add(DataModel(nestedList3, "Dinner"))

        viewModel.getDailyProgress()

        viewModel.responseDailyProgress.observe(viewLifecycleOwner) { responseDailyProgress ->
            if (responseDailyProgress != null) {
                binding(responseDailyProgress)
            } else {
                viewModel.createDailyProgress()
            }
        }

        return binding.root
    }

    private fun binding(responseDailyProgress: DailyProgress) {
        binding.upMenuCaloriesText.text =
            (responseDailyProgress.goalKcal - responseDailyProgress.currentKcal).toString()
        binding.upMenuProteinsBar.progress =
            (responseDailyProgress.currentProteins / responseDailyProgress.goalProteins).toInt() * 100
        binding.upMenuProteinsLeft.text =
            (responseDailyProgress.goalProteins - responseDailyProgress.currentProteins).toString() + " left"
        binding.upMenuCarbsBar.progress =
            (responseDailyProgress.currentCarbs / responseDailyProgress.goalCarbs).toInt() * 100
        binding.upMenuCarbsLeft.text =
            (responseDailyProgress.goalCarbs - responseDailyProgress.currentCarbs).toString() + " left"
        binding.upMenuFatsBar.progress =
            (responseDailyProgress.currentFats / responseDailyProgress.goalFats).toInt() * 100
        binding.upMenuFatsLeft.text =
            (responseDailyProgress.goalFats - responseDailyProgress.currentFats).toString() + " left"
    }

    private fun getCurrentUnixDay(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis / 1000
    }
}


//        binding.button.setOnClickListener {
//            findNavController().navigate(R.id.action_diaryFragment_to_productsFragment)
//        }
//        mAdapter.attachDelegate(object : ItemDelegate {
//            override fun openProduct(id: String) {
//                navigateToProduct(id = id)
//            }
//
//            override fun openFood(id: String) {
//                navigateToFood(id = id)
//            }
//
//            override fun openMeal(id: String) {
//                navigateToMeal(id = id)
//            }
//
//            override fun addProduct(model: Item) {
//                navigateToProduct("2")
////                addData(model = model, data = Data.generateProduct())
////                addData(data = Data.generateAddProduct())
//            }
//
//            override fun addFood(id: String) {
////                addData(data = Data.generateFood())
////                addData(data = Data.generateAddProduct())
////                addData(data = Data.generateAddFood())
//            }
//
//            override fun addMeal(id: String) {
////                addData(data = Data.generateMeal())
////                addData(data = Data.generateAddFood())
////                addData(data = Data.generateAddMeal())
//            }
//
//        })
//        binding.recyclerView.layoutManager = LinearLayoutManager(this@DiaryFragment.context)
////            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
//
//        binding.recyclerView.adapter = mAdapter
//
//
////        Handler(Looper.getMainLooper()).postDelayed({
////            Toast.makeText(applicationContext, "data updated", Toast.LENGTH_SHORT).show()
////            val items = Data.generateItem().map { ItemMapper().mapApiToUi(it) }
////            val utils = ItemsDiffUtils(mAdapter.mDataList, items)
////            val diffResult = DiffUtil.calculateDiff(utils)
////            mAdapter.setData(items)
////            diffResult.dispatchUpdatesTo(mAdapter)
////        }, 4000)
//        return binding.root
//    }
//
//    fun navigateToProduct(id: String) {
//        findNavController().navigate(R.id.action_diaryFragment_to_productsFragment)
////        val intent = Intent(applicationContext, ProductActivity::class.java)
////        intent.putExtra("id", id)
////        startActivity(intent)
////        Toast.makeText(this, "Product!", Toast.LENGTH_SHORT).show()
//    }
//
//    fun navigateToFood(id: String) {
//
////        Toast.makeText(this, "Food$id", Toast.LENGTH_SHORT).show()
////        val intent = Intent(this, ProductListActivity::class.java)
////        startActivity(intent)
//    }
//    fun navigateToMeal(id: String) {
////        Toast.makeText(this, "Meal$id", Toast.LENGTH_SHORT).show()
////        val intent = Intent(this, ProductListActivity::class.java)
////        startActivity(intent)
//    }
//    fun navigateToAdd(id: String) {
////        Toast.makeText(this, "Add$id", Toast.LENGTH_SHORT).show()
//    }
//    fun populateData() {
////        val items = Data.generateItem()
////        mAdapter.setData(data = items.map {ItemMapper().mapApiToUi(api = it)})
//    }
//
//    fun addData(model: Item, data: Item) {
//        val oldList = mAdapter.mDataList.toMutableList()
//        mAdapter.mDataList.remove(model)
//        mAdapter.addData(data = data)
//        val newList = mAdapter.mDataList
//        val utils = ItemsDiffUtils(oldList = oldList, newList = newList)
//        val diffResult = DiffUtil.calculateDiff(utils)
//        diffResult.dispatchUpdatesTo(mAdapter)
//    }
//
//    fun addData(data: Item) {
//        val oldList = mAdapter.mDataList.toMutableList()
//        mAdapter.addData(data = data)
//        val newList = mAdapter.mDataList
//        val utils = ItemsDiffUtils(oldList = oldList, newList = newList)
//        val diffResult = DiffUtil.calculateDiff(utils)
//        diffResult.dispatchUpdatesTo(mAdapter)
//    }

