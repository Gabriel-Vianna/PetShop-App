package br.edu.infnet.petshop.ui.servicos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicosModel
import kotlinx.android.synthetic.main.servico_item_view.view.imagemServico
import kotlinx.android.synthetic.main.servico_item_view.view.subtituloServico
import kotlinx.android.synthetic.main.servico_item_view.view.tituloServico

class ServicoAdapter(private val arrayList: ArrayList<ServicosModel>, val context: Context):
    RecyclerView.Adapter<ServicoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(servicosModel: ServicosModel) {
            itemView.tituloServico.text = servicosModel.title
            itemView.subtituloServico.text = servicosModel.attendance
            itemView.imagemServico.setImageResource(servicosModel.image)
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