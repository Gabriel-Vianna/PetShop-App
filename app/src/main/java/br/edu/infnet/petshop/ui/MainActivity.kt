package br.edu.infnet.petshop.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ui.home.Home
import br.edu.infnet.petshop.ui.signup.SignUpActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_main.*


const val RC_SIGN_IN = 123

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        val account = GoogleSignIn.getLastSignedInAccount(this)

        sign_in_button.visibility = View.VISIBLE

        sign_in_button.setOnClickListener{
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }


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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            goToHomeActivity()
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
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