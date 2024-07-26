package com.dmm.bootcamp.yatter2024.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dmm.bootcamp.yatter2024.ui.login.LoginDestination
import com.dmm.bootcamp.yatter2024.ui.login.PublicTimelineDestination
import com.dmm.bootcamp.yatter2024.ui.post.PostDestination
import com.dmm.bootcamp.yatter2024.ui.register.RegisterAccountDestination
import org.koin.androidx.compose.getViewModel

val LocalNavController = compositionLocalOf<NavController> {
    error("Not set a NavController!")
}

@Composable
fun MainApp(
    viewModel: MainViewModel = getViewModel(),
) {
    val navController = rememberNavController()
    val startDestination = viewModel.startDestination.collectAsState(initial = null).value
    LifecycleEventEffect(
        event = Lifecycle.Event.ON_CREATE,
    ) {
        viewModel.onCreate()
    }
    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        if (startDestination != null) {
            NavHost(
                navController = navController,
                startDestination = startDestination.route
            ) {
                LoginDestination.createNode(this)
                PublicTimelineDestination.createNode(this)
                PostDestination.createNode(this) // 追加
                RegisterAccountDestination.createNode(this)
            }
        }
    }
}