package com.tecsup.evalucion03app.vistas.book

import android.app.Application
import androidx.lifecycle.LiveData
import com.tecsup.evalucion03app.database.EvaluacionRoomDatabase
import com.tecsup.evalucion03app.model.Libro
import com.tecsup.evalucion03app.model.dao.LibroDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository (application: Application){
    private val bookDao: LibroDao? = EvaluacionRoomDatabase.getInstance(application)?.libroDao()

    //LiveData:
    fun getBooks(): LiveData<List<Libro>> {
        return bookDao?.getListBook()!!
    }

    //Registro
    suspend fun insertBookWithCoroutines(book: Libro){
        processInsertBook(book)
    }
    private suspend fun processInsertBook(book: Libro){
        withContext(Dispatchers.Default){
            bookDao?.insert(book)
        }
    }

    // Actualizar
    suspend fun updateBookWithCoroutines(libro: Libro) {
        processUpdateBook(libro)
    }
    private suspend fun processUpdateBook(libro: Libro) {
        withContext(Dispatchers.Default) {
            bookDao?.update(libro)
        }
    }

}