package br.edu.infnet.petshop.ui.perfil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import br.edu.infnet.petshop.databinding.ActivityPerfilBinding
import br.edu.infnet.petshop.ui.listaservicos.ServicoItemAdapter
import kotlinx.android.synthetic.main.activity_perfil.recyclerViewHistory

class PerfilActivity : AppCompatActivity() {

    private var servicoItemAdapter: RecyclerView.Adapter<ServicoItemAdapter.ViewHolder>? = null
    lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayList = ArrayList<ServicosModel>()

        arrayList.add(
            ServicosModel("Banho", "Serviço realizado em:", "01/12/2021", "14:00h", "R$50,00",
            R.drawable.banho_logo
        )
        )
        arrayList.add(
            ServicosModel("Tosa", "Serviço realizado em:", "01/12/2021", "13:00h", "R$70,00",
            R.drawable.tosa_logo
        )
        )

        recyclerViewHistory.adapter = servicoItemAdapter
        recyclerViewHistory.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ServicoItemAdapter(arrayList, this.context)
        }
    }

}