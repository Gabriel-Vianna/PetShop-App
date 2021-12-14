package br.edu.infnet.petshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            var textViewEmail = findViewById<EditText>(R.id.editTextEmail).text.toString()
            var textViewPassword = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if(textViewEmail == "gabriel@gmail.com" && textViewPassword == "123456") {
                alert("Login realizado com sucesso!")
                goToHomeActivity()
            }else {
                alert("Email ou senha incorretos")
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
}