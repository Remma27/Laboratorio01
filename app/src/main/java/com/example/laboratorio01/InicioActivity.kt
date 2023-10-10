package com.example.laboratorio01

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.laboratorio01.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_inicio)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // cambios de jose
        supportActionBar?.title = "¡Bienvenido a la Fiesta de Halloween!"

        // Configura un mensaje en el botón flotante para relacionarlo con la comida de Halloween
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Explora nuestros deliciosos platillos de Halloween", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        // cambios de jose

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_inicio)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
