package com.projetointegrador.desafiowebservices.sign.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.projetointegrador.desafiowebservices.R

class SignUpFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onRegister(_view)
        checkNameChanged(_view)
        checkEmailChanged(_view)
        checkPasswordChanged(_view)
    }

    private fun onRegister(view: View) {
        view.findViewById<TextView>(R.id.btnSignUpRegister).setOnClickListener {
            if(checkName(view) && checkEmail(view) && checkPassword(view))
                view.findNavController().navigate(R.id.action_signUpFragment_to_comicLibraryFragment)
        }
    }

    private fun checkName(view: View): Boolean {
        var checkResult: Boolean = false
        val name = view.findViewById<TextInputEditText>(R.id.etSignUpName).text
        if (name != null) {
            if (name.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.tiSignUpName).error =
                    getString(R.string.name_null_error)
                checkResult = false
            }else
                checkResult = true
        }
        return checkResult
    }

    private fun checkEmail(view: View): Boolean {
        var checkResult: Boolean = false
        val email = view.findViewById<TextInputEditText>(R.id.etSignUpEmail).text
        if (email != null) {
            if (email.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.tiSignUpEmail).error =
                    getString(R.string.email_null_error)
                checkResult = false
            }else
                checkResult = true
        }
        return checkResult
    }

    private fun checkPassword(view: View): Boolean {
        var checkResult: Boolean = false
        val password = view.findViewById<TextInputEditText>(R.id.etSignUpPassword).text
        if (password != null) {
            if (password.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.tiSignUpPassword).error =
                    getString(R.string.password_null_error)
                checkResult = false
            }else
                checkResult = true
        }
        return checkResult
    }

    private fun checkNameChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.etSignUpName)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int,count: Int,after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.tiSignUpName).error = ""
                }
            })
    }

    private fun checkEmailChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.etSignUpEmail)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int,count: Int,after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.tiSignUpEmail).error = ""
                }
            })
    }

    private fun checkPasswordChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.etSignUpPassword)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int,count: Int,after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.tiSignUpPassword).error = ""
                }
            })
    }

}