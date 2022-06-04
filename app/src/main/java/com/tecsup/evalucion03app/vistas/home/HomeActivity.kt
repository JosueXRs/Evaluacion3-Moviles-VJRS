package com.tecsup.evalucion03app.vistas.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tecsup.evalucion03app.R
import com.tecsup.evalucion03app.vistas.book.BookFragment

class HomeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionBar = supportActionBar
        actionBar?.hide()

        openFragment(BookFragment.newInstance())
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayoutContent,fragment)
        transaction.commit()

    }
}