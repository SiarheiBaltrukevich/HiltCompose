package com.boltic28.hiltcompose.injectables

import javax.inject.Inject
import javax.inject.Singleton

/**
 * you can define scope for injectable class
 */

@Singleton
class WordsKeeper @Inject constructor(){

    val short = "not bad"

    val long = "you are great"
}