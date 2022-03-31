package br.edu.infnet.petshop.ui.servico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.databinding.ActivityServicoBinding
import br.edu.infnet.petshop.utils.ServicoEnum

class ServicoActivity : AppCompatActivity() {

    lateinit var binding: ActivityServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val servico = ServicoEnum.getById(intent.getStringExtra("SERVICO")!!.toInt())
        servico?.image?.let { binding.imagemServico.setImageResource(it) }
        binding.tituloServico.text = servico?.title
        binding.subtituloServico.text = "${servico?.days}, ${servico?.hour}"
    }
}