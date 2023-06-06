package com.foodtracker.app.presentation

import android.text.Editable

class ValidationTextInput {
    companion object {
        private const val EMAIL_LENGTH = 7
        private const val PASS_LENGTH = 8
    }

    fun validateName(text: Editable?): String? =
        if (text?.isEmpty() == false) null else "Error name"

    fun validatePassword(text: Editable?): String? =
        if (text?.isEmpty() == false && text.length >= PASS_LENGTH) null else "Error password"

    fun validateEmail(text: Editable?): String? =
        if (text?.isEmpty() == false &&
            text.contains("@", ignoreCase = true) &&
            text.length >= EMAIL_LENGTH
        ) {
            null
        } else {
            "Error email"
        }

    fun confirmPassword(password: Editable?, confirmedPassword: Editable?): String? =
        if (validatePassword(confirmedPassword) == null &&
            validatePassword(password) == null &&
            confirmedPassword.toString() == password.toString()
        ) {
            null
        } else {
            "Error confirm password"
        }
}