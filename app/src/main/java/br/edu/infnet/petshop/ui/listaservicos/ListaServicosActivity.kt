package br.edu.infnet.petshop.ui.listaservicos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicoModel
import br.edu.infnet.petshop.databinding.ActivityListaServicosBinding

class ListaServicosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaServicosBinding
    lateinit var layoutManager: LinearLayoutManager
    private var servicoItemAdapter: RecyclerView.Adapter<ServicoItemAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaServicosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList = ArrayList<ServicoModel>()
        val recyclerView = binding.listaServicos

        arrayList.add(
            ServicoModel(
                "Banho", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
                R.drawable.banho_logo
            )
        )
        arrayList.add(
            ServicoModel(
                "Tosa", "Atendimento:", "Segunda a sexta", "8h-15h", "R$70,00",
                R.drawable.tosa_logo
            )
        )
        arrayList.add(
            ServicoModel(
                "Vacina",
                "Atendimento:",
                "Segunda a sexta",
                "8h-15h",
                "Valor de acordo com a vacina",
                R.drawable.vacina_logo
            )
        )
        arrayList.add(
            ServicoModel(
                "Consulta", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
                R.drawable.consulta_logo
            )
        )
        arrayList.add(
            ServicoModel(
                "Taxi Dog",
                "Atendimento:",
                "Segunda a sexta",
                "8h-15h",
                "Valor de acordo com a distancia",
                R.drawable.taxi
            )
        )
        recyclerView.adapter = servicoItemAdapter
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ServicoItemAdapter(arrayList, this.context)
        }
    }
}