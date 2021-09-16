package com.boltic28.hiltcompose

import androidx.lifecycle.ViewModel
import com.boltic28.hiltcompose.injectables.LocalStorage
import com.boltic28.hiltcompose.hilt.annotation.SimpleHelper
import com.boltic28.hiltcompose.injectables.names.NameHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * you can use constructor to inject another injectable instances
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val storage: LocalStorage,
    @SimpleHelper private val nameHelper: NameHelper
): ViewModel() {

    fun writeData(data: String) = storage.write(data + " for " + nameHelper.provideName(), "key")

    fun readData(): String = storage.read("key")

    fun changeName() = nameHelper.changeName()

    fun getUserName(): String = nameHelper.provideName()
}