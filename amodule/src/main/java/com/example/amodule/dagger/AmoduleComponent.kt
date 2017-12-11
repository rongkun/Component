package com.kun.basekotlin.dagger

import com.example.amodule.activities.amodule_test.AModuleTestActivity
import com.kun.baselib.dagger.AppComponent
import com.kun.baselib.dagger.PerView
import dagger.Component

/**
 * @author 坤
 * @date 2017/12/6
 */
@PerView
@Component(dependencies = [AppComponent::class],
        modules = [AmoduleModule::class])
interface AmoduleComponent {
    fun inject(activity : AModuleTestActivity)
}