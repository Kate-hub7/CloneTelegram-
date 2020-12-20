package ru.sukhikh.telegramversion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.UI.fragments.EnterPhoneNumberFragment
import ru.sukhikh.telegramversion.databinding.ActivityRegisterBinding
import ru.sukhikh.telegramversion.utilits.initFirebase
import ru.sukhikh.telegramversion.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityRegisterBinding
    private lateinit var mToolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}
