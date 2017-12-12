package com.example.amodule.activities.amoduletest

import javax.inject.Inject
import com.kun.baselib.base.BasePresenter

class AModuleTestPresenter
@Inject constructor() : AModuleTestContract.Present, BasePresenter<AModuleTestContract.View>() {

}