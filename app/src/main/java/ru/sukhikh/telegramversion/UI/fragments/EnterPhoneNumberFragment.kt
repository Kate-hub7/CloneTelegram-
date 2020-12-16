package ru.sukhikh.telegramversion.UI.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import ru.sukhikh.telegramversion.MainActivity

import ru.sukhikh.telegramversion.R
import ru.sukhikh.telegramversion.activities.RegisterActivity
import ru.sukhikh.telegramversion.utilits.AUTH
import ru.sukhikh.telegramversion.utilits.replaceActivity
import ru.sukhikh.telegramversion.utilits.replaceFragment
import ru.sukhikh.telegramversion.utilits.showToast
import java.util.concurrent.TimeUnit

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    private lateinit var mPhoneNumber : String
    private lateinit var mCallback : PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onStart() {
        super.onStart()
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        showToast("Добро пожаловать")
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    }
                    else
                        showToast(task.exception?.message.toString())
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                replaceFragment(EnterCodeFragment(mPhoneNumber, id))
            }
        }
        register_next.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if(register_input_phone_number.text.toString().isEmpty()){
           showToast(getString(R.string.register_toast_enter_phone))
        }
        else{
            authUser()
           // replaceFragment(EnterCodeFragment())
        }
    }

    private fun authUser() {
        mPhoneNumber = register_input_phone_number.text.toString()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            mPhoneNumber,
            60,
            TimeUnit.SECONDS,
            activity as RegisterActivity,
            mCallback
        )
    }
}
