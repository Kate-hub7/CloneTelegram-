package ru.sukhikh.telegramversion.UI.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import ru.sukhikh.telegramversion.MainActivity
import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.utilits.APP_ACTIVITY
import ru.sukhikh.telegramversion.utilits.hideKeyboard

open class BaseChangeFragment(layout : Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        (activity as MainActivity).mAppDrawer.disableDrawer()
        hideKeyboard()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_confirm_change -> change()
        }
        return true
    }

    open fun change() {

    }
}
