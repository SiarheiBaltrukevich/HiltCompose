package com.boltic28.hiltcompose.hilt

import com.boltic28.hiltcompose.MainViewModel
import com.boltic28.hiltcompose.hilt.annotation.SimpleHelper
import com.boltic28.hiltcompose.hilt.annotation.DifficultHelper
import com.boltic28.hiltcompose.injectables.jobs.ITJob
import com.boltic28.hiltcompose.injectables.jobs.JobHelper
import com.boltic28.hiltcompose.injectables.names.NameHelper
import com.boltic28.hiltcompose.injectables.names.RussianName
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * The Hilt module [SimpleNameProvider] is annotated with @InstallIn(ViewModelComponent::class)
 * because you want Hilt to inject that dependency into [MainViewModel].
 * This annotation means that all of the dependencies in [SimpleNameProvider] are available
 * in all of the app's ViewModels.
 *
 *  |   Generated Components     |     Scopes
 *  ---------------------------------------------------
 *  | SingletonComponent         |   Application
 *  | ActivityRetainedComponent	 |   N/A
 *  | ViewModelComponent	     |   ViewModel
 *  | ActivityComponent	         |   Activity
 *  | FragmentComponent	         |   Fragment
 *  | ViewComponent	             |   View
 *  | ViewWithFragmentComponent	 |   View annotated with @WithFragmentBindings
 *  | ServiceComponent	         |   Service
 *
 *
 * this file shows how to implement simple bind of class extended from some interface
 * we have 2 different provider for this class so we use annotations
 * [DifficultHelper] and [SimpleHelper] to define which oe we have to use
*/

@Module
@InstallIn(ViewModelComponent::class)
abstract class SimpleNameProvider {

    @ViewModelScoped
    @SimpleHelper
    @Binds
    abstract fun bindNameHelper(namesVariant: RussianName): NameHelper

    @ViewModelScoped
    @Binds
    abstract fun bindJobHelper(jobVariant: ITJob): JobHelper
}