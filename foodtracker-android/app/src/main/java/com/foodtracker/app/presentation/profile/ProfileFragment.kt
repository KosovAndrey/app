package com.foodtracker.app.presentation.profile

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.foodtracker.app.R
import com.foodtracker.app.databinding.DialogChangePasswordBinding
import com.foodtracker.app.databinding.FragmentProfileBinding
import com.foodtracker.app.presentation.ValidationTextInput
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate
import java.time.Period
import java.util.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)


        viewModel.getUser()
        viewModel.responseUser.observe(viewLifecycleOwner) { responseUser ->
            if (responseUser != null) {
                with(binding) {
                    nameTextView.text = responseUser.username
                    genderTextView.text = getGender(responseUser.gender)
                    ageTextView.text = getAge(responseUser.birthdate).toString()
                    heightTextView.text = responseUser.height.toString()
                    currentWeightTextView.text = responseUser.currentWeight.toString()
                    goalWeightTextView.text = responseUser.goalWeight.toString()
                    activeTextView.text = getActive(responseUser.active)
                    emailTextView.text = responseUser.email
                }
            } else {
                Toast.makeText(this@ProfileFragment.context, "Null", Toast.LENGTH_SHORT).show()
            }
        }
//        with(binding) {
//            nameTextView.text = viewModel.getName()
//            genderTextView.text = viewModel.getGender()
//            ageTextView.text = viewModel.getBirthday() //sdflkgjsdlkgjs;dlfgjs;dlfkgjslgjsdflgkjsadlkgfjsdflgkjsdflkgj
//            heightTextView.text = viewModel.getHeight()
//            currentWeightTextView.text = viewModel.getCurrentWeight()
//            goalWeightTextView.text = viewModel.getGoalWeight()
//            activeTextView.text = viewModel.getActive()
//            emailWeightTextView.text = viewModel.getEmail()
//        }

        binding.nameTextView.setOnClickListener {
            showSetNameDialog()
        }
        binding.genderTextView.setOnClickListener {
            showSetGenderDialog()
        }
        binding.ageTextView.setOnClickListener {
            showBirthdateDialog()
        }
        binding.heightTextView.setOnClickListener {
            showHeightDialog()
        }
        binding.currentWeightTextView.setOnClickListener {
            showCurrentWeightDialog()
        }
        binding.goalWeightTextView.setOnClickListener {
            showGoalWeightDialog()
        }
        binding.activeTextView.setOnClickListener {
            showActiveDialog()
        }
        binding.emailTextView.setOnClickListener {
            showEmailDialog()
        }
        binding.passwordTextView.setOnClickListener {
            showPasswordDialog()
        }
        binding.imageViewSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        return binding.root
    }

    private fun getActive(active: Int): String {
        return when (active) {
            1 -> "Lightly active"
            2 -> "Moderately active"
            3 -> "Normal active"
            else -> "Very active"
        }

    }

    private fun getAge(birthdate: Long): Int {
        val currentDate = LocalDate.now()
        val birthdayDate = LocalDate.ofEpochDay(birthdate / (24 * 60 * 60 * 1000))
        val age = Period.between(birthdayDate, currentDate).years
        return age
    }

    private fun showBirthdateDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this.requireContext(),
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)
                val selectedDateInMillis = selectedCalendar.timeInMillis
                binding.ageTextView.text = getAge(selectedDateInMillis).toString()
                viewModel.setBirthdate(selectedDateInMillis)
                // Используйте выбранную дату в формате Long
                // Например, сохраните ее в переменную или передайте в другую функцию
                // selectedDateInMillis - это значение даты в миллисекундах с начала эпохи
            },
            year,
            month,
            day)
        datePickerDialog.show()
    }

    private fun showSetNameDialog() {
        val inputDialog = AlertDialog.Builder(this.requireContext())
        inputDialog.setTitle("Enter name")

        val inputEditText = EditText(this.requireContext())
        var currentValue = binding.nameTextView.text
        inputEditText.setText(currentValue) // Установка текущего значения поля в EditText
        inputDialog.setView(inputEditText)

        inputDialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            val newValue = inputEditText.text.toString()
            currentValue = newValue
            binding.nameTextView.text = newValue
            viewModel.setName(newValue)
        })
        inputDialog.setNegativeButton("Cancel", null)
        inputDialog.show()
    }

    private fun getGender(gender: Boolean): String = if (gender) "male" else "female"
    private fun showSetGenderDialog() {
        val dialogBuilder = AlertDialog.Builder(this.requireContext())
        dialogBuilder.setTitle("Enter gender")
        dialogBuilder.setMessage("What is your gender?")
        var gender: Boolean
        dialogBuilder.setPositiveButton("Male") { dialog, which ->
            // Обработка выбора "Вариант 1"
            gender = true
            setGender(gender)
        }
        dialogBuilder.setNegativeButton("Female") { dialog, which ->
            // Обработка выбора "Вариант 2"
            gender = false
            setGender(gender)
        }
        val dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun setGender(gender: Boolean) {
        binding.genderTextView.text = getGender(gender)
        viewModel.setGender(gender)
    }

//    private fun showHeightDialog() {
//        val numberPickerDialog = AlertDialog.Builder(this.requireContext())
//        numberPickerDialog.setTitle("Enter height")
//
//        val numberPicker = NumberPicker(this.requireContext())
//        numberPicker.minValue = 0 // Минимальное значение
//        numberPicker.maxValue = 100 // Максимальное значение
//        numberPickerDialog.setView(numberPicker)
//        numberPickerDialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
//            val newValue = numberPicker.value
//            binding.heightTextView.text = newValue.toString()
//            viewModel.setHeight(newValue)
//        })
//
//        numberPickerDialog.setNegativeButton("Cancel", null)
//        numberPickerDialog.show()
//    }

    private fun showHeightDialog() {
        val dialogBuilder = AlertDialog.Builder(this.requireContext())
        dialogBuilder.setTitle("Enter height")

        val inputField = EditText(this.requireContext())
        var currentValue = binding.heightTextView.text
        inputField.setText(currentValue.toString())
        inputField.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        dialogBuilder.setView(inputField)
        dialogBuilder.setPositiveButton("OK") { dialog, which ->
            val newValue = inputField.text.toString().toIntOrNull()
            if (newValue != null) {
                binding.heightTextView.text = newValue.toString()
                viewModel.setHeight(newValue)
            }
        }
        dialogBuilder.setNegativeButton("Cancel", null)
        val dialog = dialogBuilder.create()
        dialog.show()
        inputField.requestFocus()
//        val imm = getSystemService(this.requireContext().INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        // Открытие клавиатуры
//        val inputMethodManager =
//            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }


    private fun showCurrentWeightDialog() {
        val dialogBuilder = AlertDialog.Builder(this.requireContext())
        dialogBuilder.setTitle("Enter current weight")

        val inputField = EditText(this.requireContext())
        var currentValue = binding.currentWeightTextView.text
        inputField.setText(currentValue.toString())
        dialogBuilder.setView(inputField)
        dialogBuilder.setPositiveButton("OK") { dialog, which ->
            var newValue = inputField.text.toString().replace(",", ".")

            val dotIndex = newValue.indexOf(".")
            when {
                dotIndex != -1 && dotIndex < newValue.length - 3 -> newValue =
                    newValue.substring(0, dotIndex + 2)
                //dotIndex == newValue.length - 1 -> newValue + "0"
                else -> newValue + ".0"
            }
            val value = newValue.toDoubleOrNull()
            if (value != null) {
                binding.currentWeightTextView.text = value.toString()
                viewModel.setCurrentWeight(value)
            }
        }
        dialogBuilder.setNegativeButton("Cancel", null)
        val dialog = dialogBuilder.create()
        dialog.show()
//        val imm = this.requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        inputField.requestFocus()
//         Открытие клавиатуры
//        val inputMethodManager =
//            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun showGoalWeightDialog() {
        val dialogBuilder = AlertDialog.Builder(this.requireContext())
        dialogBuilder.setTitle("Enter goal weight")

        val inputField = EditText(this.requireContext())
        var currentValue = binding.goalWeightTextView.text
        inputField.setText(currentValue.toString())
        dialogBuilder.setView(inputField)
        dialogBuilder.setPositiveButton("OK") { dialog, which ->
            var newValue = inputField.text.toString().replace(",", ".")

            val dotIndex = newValue.indexOf(".")
            when {
                dotIndex != -1 && dotIndex < newValue.length - 3 -> newValue =
                    newValue.substring(0, dotIndex + 2)
                //dotIndex == newValue.length - 1 -> newValue + "0"
                else -> newValue + ".0"
            }
            val value = newValue.toDoubleOrNull()
            if (value != null) {
                binding.goalWeightTextView.text = value.toString()
                viewModel.setGoalWeight(value)
            }
        }
        dialogBuilder.setNegativeButton("Cancel", null)
        val dialog = dialogBuilder.create()
        dialog.show()
//        val imm = this.requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        inputField.requestFocus()
//         Открытие клавиатуры
//        val inputMethodManager =
//            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    private fun showActiveDialog() {
        val options = arrayOf("Lightly active", "Moderately active", "Normal active", "Very active")
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Enter active")
        builder.setItems(options) { dialog, which ->
            // Обработка выбранного пункта
            val selectedOption = options[which]
            val value = options.indexOf(selectedOption) + 1
            viewModel.setActive(value)
            binding.activeTextView.text = selectedOption
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showEmailDialog() {
        val inputDialog = AlertDialog.Builder(this.requireContext())
        inputDialog.setTitle("Enter email")

        val inputEditText = EditText(this.requireContext())
        var currentValue = binding.emailTextView.text
        inputEditText.setText(currentValue) // Установка текущего значения поля в EditText
        inputDialog.setView(inputEditText)

        inputDialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            val newValue = inputEditText.text.toString()
            currentValue = newValue
            binding.emailTextView.text = newValue
            viewModel.setEmail(newValue)
        })
        inputDialog.setNegativeButton("Cancel", null)
        inputDialog.show()
    }

    private fun showPasswordDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_change_password, null)
        //val bindingDialog = DialogChangePasswordBinding.inflate(layoutInflater)
        val editTextNewPassword = dialogView.findViewById<EditText>(R.id.editTextNewPassword)
        val editTextConfirmPassword = dialogView.findViewById<EditText>(R.id.editTextConfirmPassword)

        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)
        builder.setTitle("Change password")
        builder.setPositiveButton("Save") { dialog, which ->
//            with(bindingDialog) {
//                passwordInputLayout.error = validator.validatePassword(passwordTextInput.text)
//                confirmedPasswordInputLayout.error =
//                    validator.confirmPassword(confirmedPasswordTextInput.text,
//                        passwordTextInput.text)
//                if (passwordInputLayout.error == null && confirmedPasswordInputLayout.error == null) {
//                    viewModel.setPassword(password = passwordTextInput.text.toString())
//                }
//                viewModel.setPassword(password = passwordTextInput.text.toString())
//            }
//            bindingDialog.passwordInputLayout.error =
//                validator.validatePassword(bindingDialog.passwordTextInput.text)
//            bindingDialog.confirmedPasswordInputLayout.error =
//                validator.confirmPassword(bindingDialog.confirmedPasswordTextInput.text,
//                    bindingDialog.passwordTextInput.text)
//            if (bindingDialog.passwordInputLayout.error == null && bindingDialog.confirmedPasswordInputLayout.error == null) {
//                viewModel.setPassword(password = bindingDialog.passwordTextInput.text.toString())
//            }
            if(editTextConfirmPassword.text == editTextNewPassword.text) {
                viewModel.setPassword(password = editTextNewPassword.text.toString())
            }
//            viewModel.setPassword(password = bindingDialog.passwordTextInput.text.toString())
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}

