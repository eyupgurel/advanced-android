package com.alienstar.cyrus.advancedandroid.home

import com.alienstar.cyrus.advancedandroid.R
import com.alienstar.cyrus.advancedandroid.base.BaseActivity
import com.alienstar.cyrus.advancedandroid.trending.TrendingReposController
import com.bluelinelabs.conductor.Controller

class MainActivity : BaseActivity() {
    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialScreen(): Controller {
        return TrendingReposController()
    }
}
