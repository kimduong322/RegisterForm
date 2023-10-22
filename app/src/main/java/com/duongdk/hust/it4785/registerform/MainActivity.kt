package com.duongdk.hust.it4785.registerform

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.duongdk.hust.it4785.registerform.R

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var birthdayText: TextView
    private lateinit var addressEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var termsCheckBox: CheckBox
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        firstNameEditText = findViewById(R.id.firstName)
        lastNameEditText = findViewById(R.id.lastName)
        genderRadioGroup = findViewById(R.id.gender)
        birthdayText = findViewById(R.id.birthday_text)
        addressEditText = findViewById(R.id.address)
        emailEditText = findViewById(R.id.email)
        termsCheckBox = findViewById(R.id.terms_checkbox)
        registerButton = findViewById(R.id.register)

        // Set a click listener for the Register button
        registerButton.setOnClickListener {
            if (validateForm()) {
                // All required fields are filled, and terms are accepted
                // You can perform registration or other actions here
                showToast("Registration successful!")
            }
        }
    }

    private fun validateForm(): Boolean {
        if (firstNameEditText.text.isNullOrBlank() ||
            lastNameEditText.text.isNullOrBlank() ||
            genderRadioGroup.checkedRadioButtonId == -1 ||
            birthdayText.text.toString() == "mm/dd/yyyy" ||
            addressEditText.text.isNullOrBlank() ||
            emailEditText.text.isNullOrBlank() ||
            !termsCheckBox.isChecked
        ) {
            showToast("Please fill in all required fields and accept the terms.")
            return false
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
