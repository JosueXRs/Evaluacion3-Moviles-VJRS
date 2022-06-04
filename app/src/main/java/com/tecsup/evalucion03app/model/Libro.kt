package com.tecsup.evalucion03app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Libro(
    @ColumnInfo(name="nombre_book")
    val nombre:String,

    @ColumnInfo(name="autor_book")
    val autor:String,

    @ColumnInfo(name="categoria_book")
    val categoria:String,

    @ColumnInfo(name="editorial_book")
    val editorial:String,

    @ColumnInfo(name="resumen_book")
    val resumen:String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="book_id")
    var bookID: Int = 0
}