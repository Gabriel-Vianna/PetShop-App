package br.edu.infnet.petshop.ui.servico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.databinding.ActivityServicoBinding

class ServicoActivity : AppCompatActivity() {

    lateinit var binding: ActivityServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}