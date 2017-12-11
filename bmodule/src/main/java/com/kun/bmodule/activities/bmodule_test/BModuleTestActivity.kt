package com.kun.bmodule.activities.bmodule_test

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kun.basekotlin.dagger.DaggerBmoduleComponent
import com.kun.baselib.base.BaseActivity
import com.kun.bmodule.R

@Route(path = "/bmodule/test")
class BModuleTestActivity : BaseActivity<BModuleTestPresenter>(), BModuleTestContract.View {

    override fun daggerInit() {
        DaggerBmoduleComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmodule_test)
        mPresenter.attachView(this)
    }
}
