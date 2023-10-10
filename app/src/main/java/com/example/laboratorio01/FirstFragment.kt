package com.example.laboratorio01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import com.example.laboratorio01.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    private lateinit var editTextComentario: EditText
    private lateinit var botonAgregarComentario: Button
    private lateinit var listViewComentarios: ListView
    private val listaComentarios = mutableListOf<String>()
    private lateinit var adaptador: ArrayAdapter<String> // Mueve la declaración de adaptador aquí

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        editTextComentario = binding!!.editTextComentario
        botonAgregarComentario = binding!!.buttonFirst
        listViewComentarios = binding!!.listViewComentarios

        // Adaptador para la lista de comentarios
        adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listaComentarios)
        listViewComentarios.adapter = adaptador

        // Agregar comentario al hacer clic en el botón o al presionar Enter
        botonAgregarComentario.setOnClickListener {
            agregarComentario()
        }

        editTextComentario.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                agregarComentario()
                true
            } else {
                false
            }
        }

        binding!!.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun agregarComentario() {
        val comentario = editTextComentario.text.toString()
        if (comentario.isNotEmpty()) {
            listaComentarios.add(comentario)
            adaptador.notifyDataSetChanged()
            editTextComentario.text.clear()
            // Desplázate hasta la última posición de la lista
            listViewComentarios.smoothScrollToPosition(listaComentarios.size - 1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
