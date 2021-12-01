package com.dscorp.mvvmexample.presentation.main

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dscorp.mvvmexample.databinding.ActivityMainBinding
import com.dscorp.mvvmexample.presentation.DialogFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private val viewModel by viewModels<MainViewModel>()
    lateinit var dialogFactory: DialogFactory

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.pokemons().observe(this, Observer { pokemons ->
            Toast.makeText(this, "Se recibieron los pokemons desde la api!", Toast.LENGTH_LONG).show()
            for (pokemon in pokemons) {
                Log.i("POKEMONS", pokemon.name)
            }
        })

        dialogFactory = DialogFactory(this)

        var editor = sharedPreferences.edit()
        editor.putString("nombre", "sergio")
        editor.commit()

        val name = sharedPreferences.getString("nombre", "")

        with(binding)
        {
            tvHelloworld.text = "Hola $name"
        }

        val context = this

        GlobalScope.launch {
            withContext(Dispatchers.Main) {

                delay(2000)

                var dialog1 =
                    dialogFactory.createDialog(DialogFactory.DialogType.message, "Bienvenido $name")
                dialog1?.show()

            }
        }


    }
}