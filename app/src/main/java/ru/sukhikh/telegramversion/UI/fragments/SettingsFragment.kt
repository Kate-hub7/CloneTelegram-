package ru.sukhikh.telegramversion.UI.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ru.sukhikh.telegramversion.MainActivity
import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.activities.RegisterActivity
import ru.sukhikh.telegramversion.utilits.AUTH
import ru.sukhikh.telegramversion.utilits.replaceActivity

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}
