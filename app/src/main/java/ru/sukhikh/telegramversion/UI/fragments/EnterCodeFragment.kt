package ru.sukhikh.telegramversion.UI.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*
import ru.sukhikh.telegramversion.MainActivity

import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.activities.RegisterActivity
import ru.sukhikh.telegramversion.utilits.AUTH
import ru.sukhikh.telegramversion.utilits.AppTextWatcher
import ru.sukhikh.telegramversion.utilits.replaceActivity
import ru.sukhikh.telegramversion.utilits.showToast

class EnterCodeFragment(val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber

        register_input_code.addTextChangedListener(AppTextWatcher{

                val string = register_input_code.text.toString()
                if(string.length==6){
                    enterCode()
                }
        })
    }

    fun enterCode(){
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if(task.isSuccessful){
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            }
            else
                showToast(task.exception?.message.toString())
        }
    }
}
