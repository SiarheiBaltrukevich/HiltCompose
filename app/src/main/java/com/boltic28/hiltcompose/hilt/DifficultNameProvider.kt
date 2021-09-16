package com.boltic28.hiltcompose.hilt

import android.content.Context
import com.boltic28.hiltcompose.hilt.annotation.DifficultHelper
import com.boltic28.hiltcompose.hilt.annotation.SimpleHelper
import com.boltic28.hiltcompose.injectables.names.NameHelper
import com.boltic28.hiltcompose.injectables.names.RussianName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

/**
 * this file shows how to implement difficult(with additional logic for creating the class)
 * bind of class extended from some interface
 * we have 2 different provider for this class so we use annotations
 * [DifficultHelper] and [SimpleHelper] to define which oe we have to use
 */

@Module
@InstallIn(ActivityComponent::class)
object DifficultNameProvider {

    @ActivityScoped
    @DifficultHelper
    @Provides
    fun bindNameHelper(@ApplicationContext context: Context): NameHelper {
        // do something with parameters
        context.resources
        return RussianName()
    }

}