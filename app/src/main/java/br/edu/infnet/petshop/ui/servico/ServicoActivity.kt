package br.edu.infnet.petshop.ui.servico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.petshop.ServicoModel
import br.edu.infnet.petshop.databinding.ActivityServicoBinding
import br.edu.infnet.petshop.ui.listaservicos.ServicoItemAdapter
import com.google.gson.Gson

class ServicoActivity : AppCompatActivity() {

    lateinit var binding: ActivityServicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val servico = Gson().fromJson<ServicoModel>(intent.getStringExtra("SERVICO"), ServicoItemAdapter::class.java)
        binding.tituloServico.text = servico.title
        binding.subtituloServico.text = servico.attendance
    }
}