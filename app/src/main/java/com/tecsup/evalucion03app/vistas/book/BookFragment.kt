package com.tecsup.evalucion03app.vistas.book

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tecsup.evalucion03app.R
import com.tecsup.evalucion03app.model.Libro
import kotlinx.android.synthetic.main.dialog_book.*
import kotlinx.android.synthetic.main.dialog_book.view.*
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment: Fragment(), BookAdapter.ItemClickListener {

    private lateinit var bookViewModel: BookViewModel
    lateinit var list: List<Libro>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }
    companion object {
        fun newInstance(): BookFragment = BookFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookViewModel = run {
            ViewModelProviders.of(this).get(BookViewModel::class.java)
        }
        fabRegisterBook.setOnClickListener {
            registerAndUpdateBook(null, BookTypeOperation.REGISTER)
        }
        loadData()
    }
    private fun loadData(){
        val adapter = BookAdapter(this)
        recyclerBooks.adapter = adapter
        recyclerBooks.layoutManager = LinearLayoutManager(activity)

        bookViewModel.books.observe(viewLifecycleOwner){ books ->
            if(books.isNotEmpty()){
                list = books
                books?.let {
                    adapter.setBooks(books)
                }
            }
        }
    }

    private fun registerAndUpdateBook(libro: Libro?, type: BookTypeOperation) {
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_book, null)
        val titleAlertLibro = if (type == BookTypeOperation.REGISTER) "Registrar Nuevo Libro" else "Editar Libro"
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(titleAlertLibro)
        val mAlertDialog = mBuilder.show()
        if (type == BookTypeOperation.UPDATE){
            mDialogView.edtNombreBook.setText(libro?.nombre)
            mDialogView.edtAutorBook.setText(libro?.autor)
            mDialogView.edtCategoriaBook.setText(libro?.categoria)
            mDialogView.edtEditorialBook.setText(libro?.editorial)
            mDialogView.edtResumenBook.setText(libro?.resumen)
        }

        mAlertDialog.btnRegisterBook.setOnClickListener {
            mAlertDialog.dismiss()
            val nombreBook = mDialogView.edtNombreBook.text.toString()
            val autorBook = mDialogView.edtAutorBook.text.toString()
            val categoriaBook = mDialogView.edtCategoriaBook.text.toString()
            val editorialBook = mDialogView.edtEditorialBook.text.toString()
            val resumenBook = mDialogView.edtResumenBook.text.toString()
            var book = Libro(nombreBook, "Autor: " + autorBook, "Categoria: " + categoriaBook, "Editorial: " + editorialBook, resumenBook)

            if (type == BookTypeOperation.REGISTER){
                bookViewModel.saveBook(book)
            }else{
                if(libro != null){
                    book.bookID = libro.bookID
                }
                bookViewModel.updateBook(book)
            }
        }
    }

    override fun onItemClick(libro: Libro) {
        registerAndUpdateBook(libro, BookTypeOperation.UPDATE)
    }

}