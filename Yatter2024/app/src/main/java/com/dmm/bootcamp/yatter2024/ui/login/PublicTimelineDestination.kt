package com.dmm.bootcamp.yatter2024.ui.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.dmm.bootcamp.yatter2024.common.navigation.Destination
import com.dmm.bootcamp.yatter2024.ui.timeline.PublicTimelinePage

class PublicTimelineDestination(
    builder: (NavOptionsBuilder.() -> Unit)? = null,
) : Destination(ROUTE, builder) {
    companion object {
        private const val ROUTE = "publicTimeline"

        fun createNode(builder: NavGraphBuilder) {
            builder.composable(ROUTE) {
                PublicTimelinePage()
            }
        }
    }
}