package br.edu.infnet.petshop.ui.contato

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.R
import kotlinx.android.synthetic.main.acitivity_contato.emailAddress
import kotlinx.android.synthetic.main.acitivity_contato.phoneCall

class ContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_contato)

        val phoneNumber = phoneCall.text.toString()
        val email = emailAddress.text.toString()
        phoneCall.setOnClickListener{
            val intentPhoneCall = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intentPhoneCall)
        }

        emailAddress.setOnClickListener{
            val intentMail = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:$email")
            }
            startActivity(intentMail)
        }
    }
}