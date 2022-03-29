package br.edu.infnet.petshop.ui.listaservicos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import br.edu.infnet.petshop.databinding.ActivityListaServicosBinding

class ListaServicosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaServicosBinding
    lateinit var layoutManager: LinearLayoutManager
    lateinit var servicoItemAdapter: RecyclerView.Adapter<ServicoItemAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaServicosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList = ArrayList<ServicosModel>()
        val recyclerView = binding.listaServicos

        arrayList.add(
            ServicosModel(
                "Banho", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
                R.drawable.banho_logo
            )
        )
        arrayList.add(
            ServicosModel(
                "Tosa", "Atendimento:", "Segunda a sexta", "8h-15h", "R$70,00",
                R.drawable.tosa_logo
            )
        )
        arrayList.add(
            ServicosModel(
                "Vacina",
                "Atendimento:",
                "Segunda a sexta",
                "8h-15h",
                "Valor de acordo com a vacina",
                R.drawable.vacina_logo
            )
        )
        arrayList.add(
            ServicosModel(
                "Consulta", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
                R.drawable.consulta_logo
            )
        )
        arrayList.add(
            ServicosModel(
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