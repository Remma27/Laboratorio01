import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio01.Event
import com.example.laboratorio01.EventAdapter
import com.example.laboratorio01.R
import com.example.laboratorio01.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //jhon
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val eventList = generateSampleEvents()
        val adapter = EventAdapter(eventList)
        recyclerView.adapter = adapter
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        //jhon


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        // Configura la ActionBar con el NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }

    // Agrega este método para configurar la ActionBar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun generateSampleEvents(): List<Event> {
        val eventList = mutableListOf<Event>()
        eventList.add(Event("      CAZA DE BRUJAS", "EMMANUEL SOLANO", "\"¡Únete a nosotros en un emocionante día de caza de brujas, tendremos música de Rauw Alejandro y nos vamos a estallar calabazas en la jupa! Participa en nuestro concurso de quien queda tieso primero y muestra tus habilidades misticas en esta celebración única.,\"", "11/10/2023", "DESCRIPCION", ))
        eventList.add(Event("FIESTA EN BODEGA", "         JOSE NUÑEZ ",  "Celebremos Halloween con una fiesta espeluznante en la bodega de mi chante! Degusta los jagger y pachas con jet especiales mientras disfrutas de música de ANUEL . Y, por supuesto, no te olvides del disfraz de anuel.", "10/10/2023", "DESCRIPCION",))
        eventList.add(Event("      DULCE O PLOMO", "ALEJANDRO JOSE",  " ¿Estás listo para un desafío de Halloween? Únete a nuestra caza de dulces al puro estilo de barranca!. Resuelve discusiones con plomo y sigue pistas en un emocionante recorrido por los bulevares que te llevará a encontrar tesoros espeluznantes. ", "20/10/2023", "DESCRIPCION",))
        eventList.add(Event("INVOCAR A SHREK", "      JHON ALLEN",  "Te invitamos a formar parte de nuestra nueva secta para alabar a Shrek a las 3 de la mañana, la reunion será en el parque del roble, recuerden llevar 3 tamagotchis y cuatro latas de birras!", "25/10/2023", "DESCRIPCION",))
        eventList.add(Event("INFARTAR A PIQUÉ", "                SHAKIRA",  "¡Adéntrate en nuestra mision y hagamos experimentar el miedo mi expareja con payasos asesinos con cara de Clara Chia bailando WAKA en su máxima expresión! ¡Te prometemos que no podrás escapar de la emoción!", "14/10/2023", "DESCRIPCION",))
        eventList.add(Event("PLEITO EN EL CERRO CON EL DIABLO", "              JESUCRISTO",  "Amados seres de la tierra! Os reuno a vosotros el dia de hoy para partirle la jeta al chamuco junto al abuelo y su machete, os invito a medianoche para hacer justicia, faltar es un pecado!!!!!", "30/10/2023", "DESCRIPCION",))

        return eventList
    }
}
