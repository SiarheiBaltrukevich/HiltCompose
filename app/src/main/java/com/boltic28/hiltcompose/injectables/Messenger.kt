package com.boltic28.hiltcompose.injectables

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * injectable class can include other injectables
 * into constructor or in class body
 */
class Messenger @Inject constructor(
    @ApplicationContext private val context: Context,
    private val words: WordsKeeper
) {

    private var variant = true

    private fun provideWord(): String =
        if (variant) {
            variant = false
            words.long
        } else {
            variant = true
            words.short
        }

    fun showMessage(message: String) {
        Toast.makeText(context, message + ", " + provideWord(), Toast.LENGTH_LONG).show()
    }
}