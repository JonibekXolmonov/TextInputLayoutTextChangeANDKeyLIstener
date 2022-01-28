package com.example.textinputlayouttextchangekeylistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputLayout: TextInputLayout
    private lateinit var textInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textInputLayout = findViewById(R.id.layout_input)
        textInputEditText = findViewById(R.id.edt_input)

        textChangedListener()

        onKeyListener()
    }


    private fun onKeyListener() {
        textInputEditText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                Toast.makeText(applicationContext, "goooooo", Toast.LENGTH_SHORT).show()
                return@OnKeyListener true
            }
            false
        })

    }

    private fun textChangedListener() {
        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.toString()[s.toString().length - 1].isDigit()) {
                    textInputLayout.error = "Digit input"
                } else {
                    textInputLayout.isErrorEnabled = false
                }
            }
        })
    }
}
