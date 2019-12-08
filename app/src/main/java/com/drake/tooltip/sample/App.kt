package com.drake.tooltip.sample

import android.app.Application
import android.view.View
import com.drake.tooltip.ToastConfig
import kotlinx.android.synthetic.main.layout_toast_error.view.*

class App : Application() {

    companion object {
        const val LEVEL_ERROR = 1
    }

    override fun onCreate() {
        super.onCreate()

        ToastConfig.onLevel { msg, level ->
            when (level) {
                LEVEL_ERROR -> {
                    View.inflate(this@App, R.layout.layout_toast_error, null)
                        .apply { tv_msg.text = msg }
                }
                else -> {
                    null // 返回null表示不显示任何内容
                }
            }
        }
    }
}