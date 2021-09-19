package com.boltic28.hiltcompose.injectables.jobs

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ITJob @Inject constructor()  : JobHelper{

    private val jobs = listOf("sysadmin", "developer", "manager", "seller", "devops" )

    private var job = jobs.random()

    override fun provideJob(): String = job

    override fun changeJob(): String {
        var newJob = jobs.random()
        while (newJob == job) { newJob = jobs.random() }
        job = newJob
        return job
    }

}