package ni.edu.uca.clase11_10.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.clase11_10.R
import ni.edu.uca.clase11_10.databinding.TablaItemBinding
import ni.edu.uca.clase11_10.model.Tabla

class TablaAdapter(val tablaList: List<Tabla>): RecyclerView.Adapter<TablaAdapter.Holder>() {

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        //val num: TextView = view.findViewById(R.id.etNum)
        val multiplicador: TextView = view.findViewById(R.id.tvMultiplicador)
        val resultado: TextView = view.findViewById(R.id.tvResultado)

        fun cargar(tabla: Tabla) {
            val num = tabla.num
            val multi = tabla.multiplicador
            val result = num * multi
            if(multi<10)
                multiplicador.text = "$num X 0$multi =     "
            else
                multiplicador.text = "$num X $multi =     "
            resultado.text = result.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Holder(layoutInflater.inflate(R.layout.tabla_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.cargar(tablaList[position])
    }

    override fun getItemCount(): Int = tablaList.size


}