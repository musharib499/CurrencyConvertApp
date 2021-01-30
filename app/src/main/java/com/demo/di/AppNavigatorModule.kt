package com.demo.di

import com.demo.ui.AppNavigator
import com.demo.ui.AppNavigatorInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by Musharib Ali on 30/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class AppNavigatorModule {
    @Binds
    abstract fun bindNavigator(appNavigator: AppNavigator): AppNavigatorInterface
}