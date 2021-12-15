package br.edu.infnet.petshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.viewModel.ServicesModel
import kotlinx.android.synthetic.main.row.view.*

class RecyclerViewAdapter(private val arrayList: ArrayList<ServicesModel>, val context: Context):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(servicesModel: ServicesModel) {
            itemView.titleTv.text = servicesModel.title
            itemView.attendanceTv.text = servicesModel.attendance
            itemView.daysTv.text = servicesModel.days
            itemView.hourTv.text = servicesModel.hour
            itemView.priceTv.text = servicesModel.value
            itemView.imageTv.setImageResource(servicesModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}