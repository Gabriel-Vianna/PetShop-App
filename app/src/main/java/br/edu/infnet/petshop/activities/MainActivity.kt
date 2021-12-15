package br.edu.infnet.petshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.edu.infnet.petshop.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnSignUp = findViewById<TextView>(R.id.btnSignUp)
        var extras = intent.extras

        btnSignUp.setOnClickListener {
            goToSignUpActivity()
        }

        btnLogin.setOnClickListener {
            var textViewEmail = findViewById<EditText>(R.id.editTextEmail).text.toString()
            var textViewPassword = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if (extras != null) {
                if(textViewEmail == extras.getString("email") && textViewPassword == extras.getString("password")) {
                    alert("Login realizado com sucesso!")
                    goToHomeActivity()
                }else {
                    alert("Email ou senha incorretos")
                }
            }else {
                alert("Email ou senha incorretos!")
            }
        }
    }

    private fun alert(stringAlert: String) {
        Toast.makeText(this, stringAlert, Toast.LENGTH_LONG).show()
    }

    private fun goToHomeActivity() {
        var homeActivity = Intent(this, Home::class.java)
        startActivity(homeActivity)
    }

    private fun goToSignUpActivity() {
        var signUpActivity = Intent(this, SignUpActivity::class.java)
        startActivity(signUpActivity)
    }
}