package ni.edu.uca.clase11_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.clase11_10.databinding.FragmentTablaBinding
import ni.edu.uca.clase11_10.model.Tabla
import ni.edu.uca.clase11_10.adapter.TablaAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tablaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class tablaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentTablaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTablaBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener {
            obtenerTabla()
        }
    }

    fun obtenerTabla() {
        val num = binding.etNum.text.toString().toInt()
        var listTabla = ArrayList<Tabla>()
        binding.rvTabla.layoutManager = GridLayoutManager(this.context, 2)
        for (i in 1..12){
            val tbl = Tabla(num,i,0)
            listTabla.add(tbl)
            binding.rvTabla.adapter = TablaAdapter(listTabla)
        }
    }
}