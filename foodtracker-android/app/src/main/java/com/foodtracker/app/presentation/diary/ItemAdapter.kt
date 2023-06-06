//package com.foodtracker.app.presentation.diary
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageButton
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.foodtracker.app.R
//import com.foodtracker.app.domain.model.*
//
//interface ItemDelegate {
//    fun openProduct(id: String)
//    fun openFood(id: String)
//    fun openMeal(id: String)
//    fun addProduct(model: Item)
//    fun addFood(id: String)
//    fun addMeal(id: String)
//}
//
//class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    val mDataList: MutableList<Item> = ArrayList()
//    private var delegate: ItemDelegate? = null
//
//    fun attachDelegate(delegate: ItemDelegate) {
//        this.delegate = delegate
//    }
//
//    fun setData(data: List<Item>) {
//        mDataList.clear()
//        mDataList.addAll(data)
//    }
//
//    fun addData(data: Item) {
//        mDataList.add(data)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return when (viewType) {
//            TYPE_ITEM_PRODUCT -> ProductViewHolder(itemView = inflater.inflate(R.layout.item_product,
//                parent,
//                false), delegate = delegate)
//            TYPE_ITEM_FOOD -> FoodViewHolder(itemView = inflater.inflate(R.layout.item_food,
//                parent,
//                false), delegate = delegate)
//            TYPE_ITEM_MEAL -> MealViewHolder(itemView = inflater.inflate(R.layout.item_meal,
//                parent,
//                false), delegate = delegate)
//            TYPE_ITEM_ADD_PRODUCT -> AddProductViewHolder(itemView = inflater.inflate(R.layout.item_add_product,
//                parent,
//                false), delegate = delegate)
//            TYPE_ITEM_ADD_FOOD -> AddFoodViewHolder(itemView = inflater.inflate(R.layout.item_add_food,
//                parent,
//                false), delegate = delegate)
//            TYPE_ITEM_ADD_MEAL -> AddMealViewHolder(itemView = inflater.inflate(R.layout.item_add_meal,
//                parent,
//                false), delegate = delegate)
//            else -> throw RuntimeException("error view type on create view holder")
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
//        is ProductViewHolder -> holder.bind(model = mDataList[position] as Product)
//        is FoodViewHolder -> holder.bind(model = mDataList[position] as Food)
//        is MealViewHolder -> holder.bind(model = mDataList[position] as Meal)
//        is AddProductViewHolder -> holder.bind(model = mDataList[position] as AddProduct)
//        is AddFoodViewHolder -> holder.bind(model = mDataList[position] as AddFood)
//        is AddMealViewHolder -> holder.bind(model = mDataList[position] as AddMeal)
//        else -> throw RuntimeException("error holder on bind view holder")
//    }
//
//    override fun getItemCount(): Int = mDataList.size
//
//    override fun getItemViewType(position: Int): Int = when (mDataList[position]) {
//        is Product -> TYPE_ITEM_PRODUCT
//        is Food -> TYPE_ITEM_FOOD
//        is Meal -> TYPE_ITEM_MEAL
//        is AddProduct -> TYPE_ITEM_ADD_PRODUCT
//        is AddFood -> TYPE_ITEM_ADD_FOOD
//        is AddMeal -> TYPE_ITEM_ADD_MEAL
//    }
//
//    class ProductViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val textViewNameProduct: TextView = itemView.findViewById(R.id.textViewName)
//        private val textViewProteinsProduct: TextView = itemView.findViewById(R.id.textViewProteins)
//        private val textViewCarbsProduct: TextView = itemView.findViewById(R.id.textViewCarbs)
//        private val textViewFatsProduct: TextView = itemView.findViewById(R.id.textViewFats)
//        private val textViewKcalProduct: TextView = itemView.findViewById(R.id.textViewKcal)
//        //private val imageButtonActions: ImageButton = itemView.findViewById(R.id.imageButtonActions)
//
//        //custom
//        fun bind(model: Product) {
//            textViewNameProduct.text = model.name
//            textViewProteinsProduct.text = model.proteins.toString()
//            textViewCarbsProduct.text = model.carbs.toString()
//            textViewFatsProduct.text = model.fats.toString()
//            textViewKcalProduct.text = model.kcal.toString()
//            //model.custom
////            imageButtonActions.setOnClickListener {
////                delegate?.openProduct(id = model.id)
////            }
//        }
//    }
//
//    class FoodViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val textViewNameFood: TextView = itemView.findViewById(R.id.textViewName)
//        private val textViewProteinsFood: TextView = itemView.findViewById(R.id.textViewProteins)
//        private val textViewCarbsFood: TextView = itemView.findViewById(R.id.textViewCarbs)
//        private val textViewFatsFood: TextView = itemView.findViewById(R.id.textViewFats)
//        private val textViewKcalFood: TextView = itemView.findViewById(R.id.textViewKcal)
//        //private val imageButtonActions: ImageButton = itemView.findViewById(R.id.imageButtonActions)
//        fun bind(model: Food) {
//            textViewNameFood.text = model.name
//            textViewProteinsFood.text = model.proteins.toString()
//            textViewCarbsFood.text = model.carbs.toString()
//            textViewFatsFood.text = model.fats.toString()
//            textViewKcalFood.text = model.kcal.toString()
////            imageButtonActions.setOnClickListener {
////                delegate?.openFood(id = model.id)
////            }
//        }
//    }
//
//    class MealViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val textViewNameFood: TextView = itemView.findViewById(R.id.textViewName)
//        private val textViewProteinsFood: TextView = itemView.findViewById(R.id.textViewProteins)
//        private val textViewCarbsFood: TextView = itemView.findViewById(R.id.textViewCarbs)
//        private val textViewFatsFood: TextView = itemView.findViewById(R.id.textViewFats)
//        private val textViewKcalFood: TextView = itemView.findViewById(R.id.textViewKcal)
//        //private val imageButtonActions: ImageButton = itemView.findViewById(R.id.imageButtonActions)
//        fun bind(model: Meal) {
//            textViewNameFood.text = model.name
//            textViewProteinsFood.text = model.proteins.toString()
//            textViewCarbsFood.text = model.carbs.toString()
//            textViewFatsFood.text = model.fats.toString()
//            textViewKcalFood.text = model.kcal.toString()
////            imageButtonActions.setOnClickListener {
////                delegate?.openMeal(id = model.id)
////            }
//        }
//    }
//
//    class AddProductViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val imageButtonAdd: ImageButton = itemView.findViewById(R.id.imageButtonAdd)
//        fun bind(model: AddProduct) {
//            imageButtonAdd.setOnClickListener {
//                delegate?.addProduct(model = model)
//            }
//        }
//    }
//
//    class AddFoodViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val imageButtonAdd: ImageButton = itemView.findViewById(R.id.imageButtonAdd)
//        fun bind(model: AddFood) {
//            imageButtonAdd.setOnClickListener {
//                delegate?.addFood(id = model.id)
//            }
//        }
//    }
//
//    class AddMealViewHolder(itemView: View, val delegate: ItemDelegate?) :
//        RecyclerView.ViewHolder(itemView) {
//        private val imageButtonAdd: ImageButton = itemView.findViewById(R.id.imageButtonAdd)
//        fun bind(model: AddMeal) {
//            imageButtonAdd.setOnClickListener {
//                delegate?.addMeal(id = model.id)
//            }
//        }
//    }
//
//    companion object {
//        const val TYPE_ITEM_PRODUCT = 0
//        const val TYPE_ITEM_FOOD = 1
//        const val TYPE_ITEM_MEAL = 2
//        const val TYPE_ITEM_ADD_PRODUCT = 3
//        const val TYPE_ITEM_ADD_FOOD = 4
//        const val TYPE_ITEM_ADD_MEAL = 5
//
//    }
//}
//
//
