package com.foodtracker.app.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceStorage(private val context: Context) {

    companion object {
        const val SHARED_APP = "key"
        const val SHARED_TOKEN_KEY = "token"
        const val SHARED_USER_ID_KEY = "userId"
        const val SHARED_EMAIL_KEY = "email"
        const val SHARED_NAME_KEY = "name"
        const val SHARED_GENDER_KEY = "gender"
        const val SHARED_BIRTH_KEY = "birth"
        const val SHARED_HEIGHT_KEY = "height"
        const val SHARED_ACTIVE_KEY = "active"
        const val SHARED_CURRENT_WEIGHT_KEY = "current_weight"
        const val SHARED_GOAL_WEIGHT_KEY = "goal_weight"
        const val SHARED_GOAL_KCAL_KEY = "goal_kcal"
        const val SHARED_GOAL_PROTEINS_KEY = "goal_proteins"
        const val SHARED_GOAL_CARBS_KEY = "goal_carbs"
        const val SHARED_GOAL_FATS_KEY = "goal_fats"
        const val SHARED_GOAL_WATER_KEY = "goal_water"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_APP, Context.MODE_PRIVATE)

    var accessToken: String
        get() = preferences.getString(SHARED_TOKEN_KEY, "").toString()
        set(value) = preferences.edit().putString(SHARED_TOKEN_KEY, value).apply()

    var userId: String
        get() = preferences.getString(SHARED_USER_ID_KEY, "").toString()
        set(value) = preferences.edit().putString(SHARED_USER_ID_KEY, value).apply()

    var email: String
        get() = preferences.getString(SHARED_EMAIL_KEY, "").toString()
        set(value) = preferences.edit().putString(SHARED_EMAIL_KEY, value).apply()

    var name: String
        get() = preferences.getString(SHARED_NAME_KEY, "").toString()
        set(value) = preferences.edit().putString(SHARED_NAME_KEY, value).apply()

    var gender: Boolean
        get() = preferences.getBoolean(SHARED_GENDER_KEY, false)
        set(value) = preferences.edit().putBoolean(SHARED_GENDER_KEY, value).apply()

    var birth: Long
        get() = preferences.getLong(SHARED_BIRTH_KEY, -1)
        set(value) = preferences.edit().putLong(SHARED_BIRTH_KEY, value).apply()

    var height: Int
        get() = preferences.getInt(SHARED_HEIGHT_KEY, -1)
        set(value) = preferences.edit().putInt(SHARED_HEIGHT_KEY, value).apply()

    var active: Int
        get() = preferences.getInt(SHARED_ACTIVE_KEY, -1)
        set(value) = preferences.edit().putInt(SHARED_ACTIVE_KEY, value).apply()

    var currentWeight: Float
        get() = preferences.getFloat(SHARED_CURRENT_WEIGHT_KEY, -1.1f)
        set(value) = preferences.edit().putFloat(SHARED_CURRENT_WEIGHT_KEY, value).apply()

    var goalWeight: Float
        get() = preferences.getFloat(SHARED_GOAL_WEIGHT_KEY, -1.1f)
        set(value) = preferences.edit().putFloat(SHARED_GOAL_WEIGHT_KEY, value).apply()

    var goalKcal: Int
        get() = preferences.getInt(SHARED_GOAL_KCAL_KEY, 0)
        set(value) = preferences.edit().putInt(SHARED_GOAL_KCAL_KEY, value).apply()

    var goalProteins: Float
        get() = preferences.getFloat(SHARED_GOAL_PROTEINS_KEY, 0.0f)
        set(value) = preferences.edit().putFloat(SHARED_GOAL_PROTEINS_KEY, value).apply()

    var goalCarbs: Float
        get() = preferences.getFloat(SHARED_GOAL_CARBS_KEY, 0.0f)
        set(value) = preferences.edit().putFloat(SHARED_GOAL_CARBS_KEY, value).apply()

    var goalFats: Float
        get() = preferences.getFloat(SHARED_GOAL_FATS_KEY, 0.0f)
        set(value) = preferences.edit().putFloat(SHARED_GOAL_FATS_KEY, value).apply()

    fun clearPreference() {
        preferences.edit()?.clear()?.apply()
    }
}