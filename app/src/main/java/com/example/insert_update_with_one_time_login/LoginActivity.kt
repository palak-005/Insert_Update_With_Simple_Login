package com.example.insert_update_with_one_time_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var userName: TextInputEditText =findViewById(R.id.edtUser)
        var password: TextInputEditText =findViewById(R.id.edtPassword)
        var button: Button =findViewById(R.id.btnSubmit)
        button.setOnClickListener {
            var user=userName.text.toString()
            var pass=password.text.toString()
            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
            {
                Toast.makeText(applicationContext,
                    "Please Enter Username/Password",
                    Toast.LENGTH_LONG).show()
            }
            else
            {
                var prefer=getSharedPreferences("MyPref", MODE_PRIVATE)
                var editor=prefer.edit()
                editor.putString("UserName",user)
                editor.commit()

                var intent= Intent(applicationContext,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}