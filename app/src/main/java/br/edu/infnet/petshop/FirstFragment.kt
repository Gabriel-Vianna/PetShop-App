package br.edu.infnet.petshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var myAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val arrayList = ArrayList<ViewModel>()

        arrayList.add(ViewModel("Banho", "Atendimento:", "Segunda a sexta", "8h-15h", "R$50,00", R.drawable.banho_logo))
        arrayList.add(ViewModel("Tosa", "Atendimento:","Segunda a sexta", "8h-15h", "R$70,00", R.drawable.tosa_logo))
        arrayList.add(ViewModel("Vacina", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a vacina", R.drawable.vacina_logo))
        arrayList.add(ViewModel("Consulta", "Atendimento:","Segunda a sexta", "8h-15h", "R$50,00", R.drawable.consulta_logo))
        arrayList.add(ViewModel("Taxi Dog", "Atendimento:","Segunda a sexta", "8h-15h", "Valor de acordo com a distancia", R.drawable.taxi))

        recyclerView.adapter = myAdapter
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MyAdapter(arrayList, this.context)
        }
    }
}