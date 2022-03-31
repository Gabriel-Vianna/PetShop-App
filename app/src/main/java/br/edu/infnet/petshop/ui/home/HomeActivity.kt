package br.edu.infnet.petshop.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.databinding.ActivityHomeBinding
import br.edu.infnet.petshop.ui.contato.ContatoActivity
import br.edu.infnet.petshop.ui.listaservicos.ListaServicosActivity
import br.edu.infnet.petshop.ui.perfil.PerfilActivity

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listaServicos.setOnClickListener{
            var serviceActivity = Intent(this, ListaServicosActivity::class.java)
            startActivity(serviceActivity)
        }

        binding.minhaConta.setOnClickListener{
            var accountActivity = Intent(this, PerfilActivity::class.java)
            startActivity(accountActivity)
        }

        binding.lojaInfo.setOnClickListener{
            var storeActivity = Intent(this, ContatoActivity::class.java)
            startActivity(storeActivity)
        }
    }
}