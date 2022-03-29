package br.edu.infnet.petshop.ui.listaservicos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import kotlinx.android.synthetic.main.servico_item_view.view.attendanceTv
import kotlinx.android.synthetic.main.servico_item_view.view.daysTv
import kotlinx.android.synthetic.main.servico_item_view.view.hourTv
import kotlinx.android.synthetic.main.servico_item_view.view.imageTv
import kotlinx.android.synthetic.main.servico_item_view.view.priceTv
import kotlinx.android.synthetic.main.servico_item_view.view.titleTv

class ServicoItemAdapter(private val arrayList: ArrayList<ServicosModel>, val context: Context):
    RecyclerView.Adapter<ServicoItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(servicosModel: ServicosModel) {
            itemView.titleTv.text = servicosModel.title
            itemView.attendanceTv.text = servicosModel.attendance
            itemView.daysTv.text = servicosModel.days
            itemView.hourTv.text = servicosModel.hour
            itemView.priceTv.text = servicosModel.value
            itemView.imageTv.setImageResource(servicosModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.servico_item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}