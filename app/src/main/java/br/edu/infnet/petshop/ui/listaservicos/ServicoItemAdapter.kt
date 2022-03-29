package br.edu.infnet.petshop.ui.listaservicos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.petshop.R
import br.edu.infnet.petshop.ServicoModel
import br.edu.infnet.petshop.ui.servico.ServicoActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.servico_item_view.view.attendanceTv
import kotlinx.android.synthetic.main.servico_item_view.view.daysTv
import kotlinx.android.synthetic.main.servico_item_view.view.hourTv
import kotlinx.android.synthetic.main.servico_item_view.view.imageTv
import kotlinx.android.synthetic.main.servico_item_view.view.priceTv
import kotlinx.android.synthetic.main.servico_item_view.view.titleTv

class ServicoItemAdapter(
    private val arrayList: ArrayList<ServicoModel>,
    val context: Context
) :
    RecyclerView.Adapter<ServicoItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(servicoModel: ServicoModel) {
            itemView.titleTv.text = servicoModel.title
            itemView.attendanceTv.text = servicoModel.attendance
            itemView.daysTv.text = servicoModel.days
            itemView.hourTv.text = servicoModel.hour
            itemView.priceTv.text = servicoModel.value
            itemView.imageTv.setImageResource(servicoModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.servico_item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        val servico = arrayList[position]
        val intent = Intent(this.context, ServicoActivity::class.java)
        intent.putExtra("SERVICO", Gson().toJson(servico))

        holder.itemView.setOnClickListener {
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}