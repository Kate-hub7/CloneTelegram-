package ru.sukhikh.telegramversion.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.sukhikh.telegramversion.MainActivity
import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.utilits.APP_ACTIVITY

open class BaseFragment(val layout : Int ) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}
