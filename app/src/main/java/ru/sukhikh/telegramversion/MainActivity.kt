package ru.sukhikh.telegramversion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import ru.sukhikh.telegramversion.UI.fragments.ChatsFragment
import ru.sukhikh.telegramversion.UI.objects.AppDrawer
import ru.sukhikh.telegramversion.activities.RegisterActivity
import ru.sukhikh.telegramversion.databinding.ActivityMainBinding
import ru.sukhikh.telegramversion.utilits.AUTH
import ru.sukhikh.telegramversion.utilits.replaceActivity
import ru.sukhikh.telegramversion.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer : AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFields(){
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
    }
    private fun initFunc(){
        if(AUTH.currentUser!=null){
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        }
       else{
            replaceActivity(RegisterActivity())
        }

    }


}
