package br.edu.infnet.petshop.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.edu.infnet.petshop.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btnServices = findViewById<Button>(R.id.listaServicos)
        var btnAccount = findViewById<Button>(R.id.minhaConta)
        var btnStore = findViewById<Button>(R.id.lojaInfo)

        btnServices.setOnClickListener{
            var serviceActivity = Intent(this, ServicesActivity::class.java)
            startActivity(serviceActivity)
        }

        btnAccount.setOnClickListener{
            var accountActivity = Intent(this, AccountActivity::class.java)
            startActivity(accountActivity)
        }

        btnStore.setOnClickListener{
            var storeActivity = Intent(this, StoreActivity::class.java)
            startActivity(storeActivity)
        }
    }
}