package br.edu.infnet.petshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(private val arrayList: ArrayList<ViewModel>, val context: Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(viewModel: ViewModel) {
            itemView.titleTv.text = viewModel.title
            itemView.attendanceTv.text = viewModel.attendance
            itemView.daysTv.text = viewModel.days
            itemView.hourTv.text = viewModel.hour
            itemView.priceTv.text = viewModel.value
            itemView.imageTv.setImageResource(viewModel.image)
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