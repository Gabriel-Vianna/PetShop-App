package br.edu.infnet.petshop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.viewModel.ServicesModel
import br.edu.infnet.petshop.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_second.*

class AccountActivity : AppCompatActivity() {
    private var recyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        val arrayList = ArrayList<ServicesModel>()

        arrayList.add(ServicesModel("Banho", "Serviço realizado em:", "01/12/2021", "14:00h", "R$50,00",
            R.drawable.banho_logo
        ))
        arrayList.add(ServicesModel("Tosa", "Serviço realizado em:", "01/12/2021", "13:00h", "R$70,00",
            R.drawable.tosa_logo
        ))
        arrayList.add(ServicesModel("Tosa", "Serviço realizado em:", "01/12/2021", "13:00h", "R$70,00",
            R.drawable.tosa_logo
        ))
        arrayList.add(ServicesModel("Tosa", "Serviço realizado em:", "01/12/2021", "13:00h", "R$70,00",
            R.drawable.tosa_logo
        ))

        recyclerViewHistory.adapter = recyclerViewAdapter
        recyclerViewHistory.apply {
            layoutManager = LinearLayoutManager(this@AccountActivity)
            adapter = RecyclerViewAdapter(arrayList, this.context)
        }
    }
}