package com.boltic28.hiltcompose.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * to create the Hilt Application you have just annotate class Application with
 * [HiltAndroidApp] annotation
 * also don't forget define name parameter into manifest file
 *
 * <application
 *      android:name=".hilt.App"
 *      ...
 * </application>
 */

@HiltAndroidApp
class App : Application() {


}