package com.boltic28.hiltcompose.injectables

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.boltic28.hiltcompose.hilt.App
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalStorage @Inject constructor(@ApplicationContext context: Context) {

    companion object{
        const val DEFAULT_STRING_VALUE = "default"
    }

    private val preferences = (context as App).getSharedPreferences("experiment", MODE_PRIVATE)

    fun write(data: String, key: String){
        with(preferences.edit()){
            putString(key, data)
            commit()
        }
    }

    fun read(key: String): String = preferences.getString(key, DEFAULT_STRING_VALUE)?: DEFAULT_STRING_VALUE
}