package br.edu.infnet.petshop.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.R
import kotlinx.android.synthetic.main.fragment_third.*

class StoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_third)

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