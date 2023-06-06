package com.foodtracker.app.presentation.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.foodtracker.app.R
import com.foodtracker.app.databinding.FragmentProductsBinding
import com.foodtracker.app.domain.model.ProductItem
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ProductsFragment : Fragment(R.layout.fragment_product) {

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var binding: FragmentProductsBinding
    private val listProducts = mutableListOf<ProductItem?>()
    private val viewModel by viewModel<ProductsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupClickListener()
        binding.buttonAddCustomProduct.setOnClickListener {
            findNavController().navigate(R.id.action_productsFragment_to_productFragment)
        }
        viewModel.getProducts()
        viewModel.responseProducts.observe(viewLifecycleOwner) { responseProducts ->
            if (responseProducts != null) {
                listProducts.clear()
                listProducts.addAll(responseProducts)
                productsAdapter.submitList(listProducts)
            } else {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
        return binding.root
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<ProductItem?>()
            for (i in listProducts) {
                if (i!!.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                Toast.makeText(this@ProductsFragment.context, "No Data found", Toast.LENGTH_SHORT)
                    .show()
            } else {
                productsAdapter.submitList(filteredList)
            }
        }
    }


    private fun setupRecyclerView() {
        with(binding.recyclerViewProducts) {
            productsAdapter = ProductsAdapter()
            adapter = productsAdapter
            recycledViewPool.setMaxRecycledViews(
                ProductsAdapter.VIEW_TYPE_CUSTOM,
                ProductsAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ProductsAdapter.VIEW_TYPE_DEFAULT,
                ProductsAdapter.MAX_POOL_SIZE
            )
        }
        setupSwipeListener(binding.recyclerViewProducts)
    }

    private fun setupSwipeListener(rvShopList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupClickListener() {
        productsAdapter.onProductItemClickListener = {
            //val bundle = Bundle()
            Log.d("MainActivity", it.toString())
//            val intent = Intent(this@ProductsFragment.context, ProductActivity::class.java)
//            intent.putExtra("productId", it.id)
//            startActivity(intent)


            //findNavController().navigate(R.id.action_navigation_task_to_productFragment)


            //findNavController().navigate(R.id.action_navigation_task_to_productFragment)
//            val fragmentB = ProductFragment.newInstance(instanceData)
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainer, fragmentB)
//                .addToBackStack(null)
//                .commit()
        }
    }

}