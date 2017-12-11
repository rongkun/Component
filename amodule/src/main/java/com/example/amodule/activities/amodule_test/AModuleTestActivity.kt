package com.example.amodule.activities.amodule_test

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

import com.example.amodule.R
import com.kun.basekotlin.dagger.DaggerAmoduleComponent

import com.kun.baselib.base.BaseActivity
import kotlinx.android.synthetic.main.activity_amodule_test.*


class AModuleTestActivity : BaseActivity<AModuleTestPresenter>(), AModuleTestContract.View {

    override fun daggerInit() {
        DaggerAmoduleComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amodule_test)
        mPresenter.attachView(this)
        btnTest.setOnClickListener({
            ARouter.getInstance().build("/bmodule/test").navigation(this)
        })
    }
}
