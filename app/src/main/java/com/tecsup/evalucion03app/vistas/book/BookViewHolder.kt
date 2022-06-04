package com.tecsup.evalucion03app.vistas.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.evalucion03app.R
import com.tecsup.evalucion03app.model.Libro

class BookViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_book, parent, false)) {

        private var textNombre: TextView? = null
        private var textAutor: TextView? = null
        private var textCategoria: TextView? = null
        private var textEditorial: TextView? = null
        private var textResumen: TextView? = null

        init {
            textNombre = itemView.findViewById(R.id.textNombre)
            textAutor = itemView.findViewById(R.id.textAutor)
            textCategoria = itemView.findViewById(R.id.textCategoria)
            textEditorial = itemView.findViewById(R.id.textEditorial)
            textResumen = itemView.findViewById(R.id.textResumen)
        }
        fun bind(libro: Libro) {
            textNombre?.text = libro.nombre
            textAutor?.text = libro.autor
            textCategoria?.text = libro.categoria
            textEditorial?.text = libro.editorial
            textResumen?.text = libro.resumen
        }

}