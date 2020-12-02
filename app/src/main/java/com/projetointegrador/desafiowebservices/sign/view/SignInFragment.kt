package com.projetointegrador.desafiowebservices.sign.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.projetointegrador.desafiowebservices.R

class SignInFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onRegister(_view)
        onLogin(_view)
        checkEmailChanged(_view)
        checkPasswordChanged(_view)
    }

    private fun onRegister(view: View) {
        view.findViewById<TextView>(R.id.tvSignInRegister).setOnClickListener {
            view.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    private fun onLogin(view: View) {
        view.findViewById<TextView>(R.id.btnSignInLogin).setOnClickListener {
            if(checkEmail(view) && checkPassword(view))
                view.findNavController().navigate(R.id.action_signInFragment_to_comicLibraryFragment)
        }
    }

    private fun checkEmail(view: View): Boolean {
        var checkResult: Boolean = false
        val email = view.findViewById<TextInputEditText>(R.id.etSignInEmail).text
        if (email != null) {
            if (email.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.tiSignInEmail).error =
                    getString(R.string.email_null_error)
                checkResult = false
            }else
                checkResult = true
        }
        return checkResult
    }

    private fun checkPassword(view: View): Boolean {
        var checkResult: Boolean = false
        val password = view.findViewById<TextInputEditText>(R.id.etSignInPassword).text
        if (password != null) {
            if (password.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.tiSignInPassword).error =
                    getString(R.string.password_null_error)
                checkResult = false
            }else
                checkResult = true
        }
        return checkResult
    }

    private fun checkEmailChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.etSignInEmail)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int,count: Int,after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        view.findViewById<TextInputLayout>(R.id.tiSignInEmail).error = ""
                }
            })
    }

    private fun checkPasswordChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.etSignInPassword)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int,count: Int,after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.tiSignInPassword).error = ""
                }
            })
    }


}