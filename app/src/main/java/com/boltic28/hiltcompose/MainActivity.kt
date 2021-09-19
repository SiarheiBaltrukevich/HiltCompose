package com.boltic28.hiltcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.boltic28.hiltcompose.elements.fragments.ButtonsGroup
import com.boltic28.hiltcompose.injectables.Messenger
import com.boltic28.hiltcompose.hilt.annotation.DifficultHelper
import com.boltic28.hiltcompose.injectables.names.NameHelper
import com.boltic28.hiltcompose.ui.theme.HiltComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

/**
 * use [AndroidEntryPoint] annotation for classes where you're going to use hilt injection
 *
 * get ViewModel for Activity or Fragment by viewmodels() extension
 *
 * to get injectable class use [Inject] annotation
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * provide viewmodel by Xlibrary
     */
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var messenger: Messenger


    /**
     * example of late initialization via Provider<T>
     * use it when you have not enough data for creating the instance
     * for example only. not used.
     */
    @Inject
    @DifficultHelper
    lateinit var nameHelperProvider: Provider<NameHelper>
    lateinit var nameHelper: NameHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //late initialization with Provider
        nameHelper = nameHelperProvider.get()

        setContent {
            HiltComposeTheme {
                ButtonsGroup(
                    sendTo = viewModel.getUserName(),
                    onApplyAction = {
                        messenger.showMessage("yellow button is clicked")
                    },
                    onWriteAction = { data ->
                        messenger.showMessage("red button is clicked")
                        viewModel.writeData(data)
                    },
                    onReadAction = {
                        messenger.showMessage("green button is clicked")
                        viewModel.readData()
                    },
                    onChangeNameAction = {
                        messenger.showMessage("gray button is clicked")
                        viewModel.changeName()
                        viewModel.changeJob()
                        viewModel.getUserInfo()
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    HiltComposeTheme {
        ButtonsGroup("name",{}, {}, { "result" }, {"name"})
    }
}