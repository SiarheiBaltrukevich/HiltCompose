package com.boltic28.hiltcompose.injectables.names

import javax.inject.Inject

/**
 * this class extend interface [NameHelper]
 * so it's constructor has to be marked @Inject annotation
 * to be provided into the Module [NameProvider]
 */

class RussianName @Inject constructor(): NameHelper {

    private val listOfNames = listOf("Ivan", "Artem", "Dmitry", "Fedor", "Makar")

    private var name = listOfNames.random()

    override fun provideName(): String = name

    override fun changeName(): String {
        var newName = listOfNames.random()
        while (newName == name) { newName = listOfNames.random() }
        name = newName
        return name
    }

}