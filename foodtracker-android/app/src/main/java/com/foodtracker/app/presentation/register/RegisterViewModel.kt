package com.foodtracker.app.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodtracker.app.domain.model.UserCreate
import com.foodtracker.app.domain.usecase.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period

class RegisterViewModel(
    private val getNameUseCase: GetNameUseCase,
    private val getGenderUseCase: GetGenderUseCase,
    private val getBirthdayUseCase: GetBirthdayUseCase,
    private val getHeightUseCase: GetHeightUseCase,
    private val getCurrentWeightUseCase: GetCurrentWeightUseCase,
    private val getGoalWeightUseCase: GetGoalWeightUseCase,
    private val getActiveUseCase: GetActiveUseCase,
    private val setTokenUseCase: SetTokenUseCase,
    private val setEmailUseCase: SetEmailUseCase,
    private val registrationUserUseCase: RegistrationUserUseCase,
    private val setGoalKcalUseCase: SetGoalKcalUseCase,
    private val setGoalProteinsUseCase: SetGoalProteinsUseCase,
    private val setGoalCarbsUseCase: SetGoalCarbsUseCase,
    private val setGoalFatsUseCase: SetGoalFatsUseCase,
) : ViewModel() {
    private val _token: MutableLiveData<String?> = MutableLiveData<String?>()
    val token: LiveData<String?> = _token
    fun getName() = getNameUseCase.execute()
    fun getSasd() = getGenderUseCase.execute()

    //fun getGender() = getGenderUseCase.execute()
//    fun getBirthday() = getBirthdayUseCase.execute()
//    fun getHeight() = getHeightUseCase.execute()
//    fun getCurrentWeight() = getCurrentWeightUseCase.execute()
//    fun getGoalWeight() = getGoalWeightUseCase.execute()
//    fun getActive() = getActiveUseCase.execute()
    fun setEmail(email: String) = setEmailUseCase.execute(email = email)

    val username: String = getNameUseCase.execute()
    val birthdate: Long = getBirthdayUseCase.execute()
    val gender: Boolean = getGenderUseCase.execute()
    val active: Int = getActiveUseCase.execute()
    val goalWeight: Float = getGoalWeightUseCase.execute()
    val currentWeight: Float = getCurrentWeightUseCase.execute()
    val height: Int = getHeightUseCase.execute()

    fun registrationUser(email: String, password: String) {
        viewModelScope.launch {
            val userCreate = UserCreate(
                username = username,
                email = email,
                gender = gender,
                birthdate = birthdate,
                height = height,
                active = active,
                currentWeight = currentWeight,
                goalWeight = goalWeight,
                password = password
            )
            val bmr = calculateBMR(userCreate)
            calculateMacronutrients(bmr)
            _token.value = registrationUserUseCase.execute(userCreate = userCreate)
            _token.value?.let { setTokenUseCase.execute(it) }
        }
    }

    private fun calculateBMR(userCreate: UserCreate): Int {
        val bmr: Double
        val weight = userCreate.currentWeight
        val height = userCreate.height
        val age = getAgeFromLong(userCreate.birthdate)
        val active = getActive(userCreate.active)
        bmr = if (userCreate.gender) { //male
            (88.36 + (13.4 * weight) + (4.8 * height) - 5.7 * age) * active
        } else { //female
            (447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age)) * active
        }
        return bmr.toInt()
    }

    private fun calculateMacronutrients(bmr: Int) {
        val proteinPercentage = 0.25f // percentage of proteins(25%)
        val fatPercentage = 0.25f // percentage of fats (25%)
        val carbPercentage = 0.5f // percentage of carbs (50%)

        val proteinCalories = proteinPercentage * bmr
        val fatCalories = fatPercentage * bmr
        val carbCalories = carbPercentage * bmr

        val proteinGrams = proteinCalories / 4 // 1 g of proteins contains 4 kcal
        val fatGrams = fatCalories / 9 // 1 g of fats contains 9 kcal
        val carbGrams = carbCalories / 4 // 1 g of carbs contains 4 kcal

        setGoalKcal(goalKcal = bmr)
        setGoalProteins(goalProteins = proteinGrams)
        setGoalCarbs(goalCarbs = carbGrams)
        setGoalFats(goalFats = fatGrams)
    }


    private fun setGoalKcal(goalKcal: Int) = setGoalKcalUseCase.execute(goalKcal)
    private fun setGoalFats(goalFats: Float) = setGoalFatsUseCase.execute(goalFats)
    private fun setGoalCarbs(goalCarbs: Float) = setGoalCarbsUseCase.execute(goalCarbs)
    private fun setGoalProteins(goalProteins: Float) = setGoalProteinsUseCase.execute(goalProteins)

    private fun getAgeFromLong(dateInMillis: Long): Int {
        val date = LocalDate.ofEpochDay(dateInMillis / (24 * 60 * 60 * 1000))
        val currentDate = LocalDate.now()
        val period = Period.between(date, currentDate)
        return period.years
    }

    private fun getActive(active: Int): Double {
        return when (active) {
            1 -> 1.2
            2 -> 1.375
            3 -> 1.55
            4 -> 1.725
            else -> 1.2
        }
    }
}