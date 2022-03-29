package br.edu.infnet.petshop.ui.servicos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import br.edu.infnet.petshop.databinding.ActivityServicosBinding

class ServicosActivity : AppCompatActivity() {

    lateinit var binding: ActivityServicosBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var servicoAdapter: RecyclerView.Adapter<ServicoAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicos)
    }

    override fun onStart() {
        super.onStart()

        val arrayList = ArrayList<ServicosModel>()

        arrayList.add(
            ServicosModel("Banho", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
            R.drawable.banho_logo
        )
        )
        arrayList.add(
            ServicosModel("Tosa", "Atendimento:","Segunda a sexta", "8h-15h", "R$70,00",
            R.drawable.tosa_logo
        )
        )
        arrayList.add(
            ServicosModel("Vacina", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a vacina",
            R.drawable.vacina_logo
        )
        )
        arrayList.add(
            ServicosModel("Consulta", "Atendimento:","Segunda a sexta", "8h-15h", "R$50,00",
            R.drawable.consulta_logo
        )
        )
        arrayList.add(
            ServicosModel("Taxi Dog", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a distancia",
            R.drawable.taxi
        )
        )
    }
}