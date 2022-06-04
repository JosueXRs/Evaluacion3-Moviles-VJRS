package com.tecsup.evalucion03app.vistas.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.evalucion03app.model.Libro

class BookAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<BookViewHolder>() {
    private var bookList = emptyList<Libro>()

    fun setBooks(libros: List<Libro>) {
        this.bookList = libros
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int = bookList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book: Libro =  bookList[position]
        holder.bind(book)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(book)
        }
    }
    interface ItemClickListener{
        fun onItemClick(libro: Libro)
    }
}