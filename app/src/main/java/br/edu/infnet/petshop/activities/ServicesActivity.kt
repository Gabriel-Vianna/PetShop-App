package br.edu.infnet.petshop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.viewModel.ServicesModel
import br.edu.infnet.petshop.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_first.*

class ServicesActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var recyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        val arrayList = ArrayList<ServicesModel>()

        arrayList.add(ServicesModel("Banho", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00",
            R.drawable.banho_logo
        ))
        arrayList.add(ServicesModel("Tosa", "Atendimento:","Segunda a sexta", "8h-15h", "R$70,00",
            R.drawable.tosa_logo
        ))
        arrayList.add(ServicesModel("Vacina", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a vacina",
            R.drawable.vacina_logo
        ))
        arrayList.add(ServicesModel("Consulta", "Atendimento:","Segunda a sexta", "8h-15h", "R$50,00",
            R.drawable.consulta_logo
        ))
        arrayList.add(ServicesModel("Taxi Dog", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a distancia",
            R.drawable.taxi
        ))

        recyclerView.adapter = recyclerViewAdapter
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ServicesActivity)
            adapter = RecyclerViewAdapter(arrayList, this.context)
        }
    }
}