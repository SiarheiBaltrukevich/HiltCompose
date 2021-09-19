package com.boltic28.hiltcompose.injectables.jobs

interface JobHelper {
    fun provideJob(): String
    fun changeJob(): String
}