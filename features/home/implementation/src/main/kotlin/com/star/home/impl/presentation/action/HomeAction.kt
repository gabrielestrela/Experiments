package com.star.home.impl.presentation.action

sealed class HomeAction {
    object OnTopHeaderMenuClick : HomeAction()
    object OnTabClick : HomeAction()
}