package br.edu.infnet.petshop.ui.perfil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import br.edu.infnet.petshop.ui.servicos.ServicoAdapter
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {
    private var servicoAdapter: RecyclerView.Adapter<ServicoAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

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

        recyclerViewHistory.adapter = servicoAdapter
        recyclerViewHistory.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ServicoAdapter(arrayList, this.context)
        }
    }

}