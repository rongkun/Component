package com.kun.basekotlin.dagger

import com.kun.baselib.dagger.AppComponent
import com.kun.baselib.dagger.PerView
import com.kun.bmodule.activities.bmoduletest.BModuleTestActivity
import dagger.Component

/**
 * @author 坤
 * @date 2017/12/6
 */
@PerView
@Component(dependencies = [AppComponent::class],
        modules = [BmoduleModule::class])
interface BmoduleComponent {
    fun inject(activity : BModuleTestActivity)
}