package br.edu.infnet.petshop.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.viewModel.ServicesModel
import br.edu.infnet.petshop.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    private var recyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val arrayList = ArrayList<ServicesModel>()

        arrayList.add(ServicesModel("Banho", "Serviço realizado em:", "01/12/2021", "14:00h", "R$50,00",
            R.drawable.banho_logo
        ))
        arrayList.add(ServicesModel("Tosa", "Serviço realizado em:", "01/12/2021", "13:00h", "R$70,00",
            R.drawable.tosa_logo
        ))

        recyclerViewHistory.adapter = recyclerViewAdapter
        recyclerViewHistory.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(arrayList, this.context)
        }
    }
}