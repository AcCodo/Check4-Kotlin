package com.example.andre_rm87145

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andre_rm87145.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    var itensAdapter = MidiaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.mainRecycler.layoutManager = LinearLayoutManager(this)
        bind.mainRecycler.adapter = itensAdapter
        itensAdapter.setItems(mutableListOf(
            MidiaModel("Star Wars 4", "Aventura", true),
            MidiaModel("Baby Rider", "Ação", true),
            MidiaModel("Harry Potter", "Aventura", false),
            MidiaModel("Miranha Verso", "PERFEIÇÃO", true)
        ))
    }
}