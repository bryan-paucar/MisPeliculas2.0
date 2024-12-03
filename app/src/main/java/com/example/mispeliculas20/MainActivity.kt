package com.example.mispeliculas20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mispeliculas20.ui.theme.MisPeliculas20Theme

/**
 * Actividad principal de la aplicación.
 *
 * Es el punto de entrada de la app, donde se establece el tema y el diseño principal
 * utilizando Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita el diseño de borde a borde para una experiencia de usuario más inmersiva.
        enableEdgeToEdge()

        // Define el contenido de la actividad con Jetpack Compose.
        setContent {
            // Se aplica el tema principal de la aplicación.
            MisPeliculas20Theme {
                // Scaffold es un contenedor que establece la estructura general de la app.
                Scaffold(
                    modifier = Modifier.fillMaxSize() // Asegura que ocupa toda la pantalla
                ) { innerPadding -> // `innerPadding` representa el espacio reservado para las barras.
                    AppScaffold()
                }
            }
        }
    }
}

/**
 * Estructura principal de la aplicación.
 *
 * Incluye:
 * - Una barra superior (AppTopBar).
 * - Una barra inferior (AppBottomBar).
 * - Un área para el contenido principal (AppContent).
 */
@Composable
fun AppScaffold() {
    Scaffold(
        // Barra superior de la interfaz.
        topBar = { AppTopBar() },

        // Barra inferior con botones y acciones.
        bottomBar = { AppBottomBar() },

        // Contenido principal.
        content = { padding ->
            AppContent(padding) // El contenido respeta los márgenes proporcionados por el Scaffold.
        }
    )
}

/**
 * Barra superior que incluye:
 * - Un título centrado.
 * - Un ícono de menú desplegable a la izquierda.
 * - Dos íconos de acción (calendario y configuración) a la derecha.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    // Variable de estado para controlar si el menú desplegable está abierto o cerrado.
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        // Colores personalizados para la barra.
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF009688), // Fondo de la barra.
            titleContentColor = Color.White, // Color del texto del título.
            navigationIconContentColor = Color.White, // Color del ícono de navegación (el menú).
            actionIconContentColor = Color.White // Color de los íconos de acción.
        ),
        title = {
            // Box para poder centrar el texto dentro de la barra superior.
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Mis Películas") // Texto que se muestra como título.
            }
        },
        navigationIcon = {
            // Ícono de menú desplegable.
            IconButton(onClick = { isMenuExpanded = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Abrir menú desplegable"
                )
            }
        },
        actions = {
            // Ícono de calendario.
            IconButton(onClick = { /* TODO: Acción del calendario */ }) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = "Abrir calendario")
            }
            // Ícono de configuración.
            IconButton(onClick = { /* TODO: Acción de configuración */ }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Abrir configuración")
            }
        }
    )

    // Menú desplegable con varias opciones.
    DropdownMenu(
        expanded = isMenuExpanded, // Controla si el menú está visible.
        onDismissRequest = { isMenuExpanded = false } // Se cierra al hacer clic fuera.
    ) {
        DropdownMenuItem(
            text = { Text("Opción 1") }, // Primera opción del menú.
            onClick = { isMenuExpanded = false } // Acción al seleccionar esta opción.
        )
        DropdownMenuItem(
            text = { Text("Opción 2") }, // Segunda opción del menú.
            onClick = { isMenuExpanded = false }
        )
        DropdownMenuItem(
            text = { Text("Opción 3") }, // Tercera opción del menú.
            onClick = { isMenuExpanded = false }
        )
    }
}

/**
 * Barra inferior que incluye:
 * - Botones de buscar, eliminar y me gusta.
 * - Un botón flotante dentro de la barra para agregar elementos.
 */
@Composable
fun AppBottomBar() {
    BottomAppBar(
        containerColor = Color(0xFF009688), // Color de fondo de la barra.
        contentColor = Color.White // Color de los íconos.
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround // Espacio uniforme entre los íconos.
        ) {
            IconButton(onClick = { /* TODO: Acción de búsqueda */ }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { /* TODO: Acción de eliminar */ }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Eliminar")
            }
            IconButton(onClick = { /* TODO: Acción de aprobación */ }) {
                Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = "Me gusta")
            }
            // Botón flotante
            FloatingActionButton(
                onClick = { /* TODO: Acción flotante */ },
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar elementos")
            }
        }
    }
}

/**
 * Contenido principal de la aplicación, que se ajusta al espacio disponible
 * y muestra una lista de películas.
 *
 * @param padding Espaciado interno proporcionado por el Scaffold.
 */
@Composable
fun AppContent(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar todo el espacio disponible.
            .padding(padding) // Ajustar el contenido al espaciado.
    ) {
        MovieListScreen() // Llama a la función que genera la lista de películas.
    }
}

/**
 * Clase de datos que representa una película.
 *
 * @property title Título de la película.
 * @property director Nombre del director.
 * @property image Id del recurso de imagen asociada.
 */
data class Movie(val title: String, val director: String, val image: Int)

/**
 * Representa un elemento individual de la lista de películas.
 *
 * @param movie Instancia de Movie con los datos de la película.
 */
@Composable
fun MovieRow(movie: Movie) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color(0xFF063041)) // Fondo con color personalizado.
    ) {
        // Imagen de la película.
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = "Portada de la película",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        // Columna con el título y director de la película.
        Column {
            Text(
                text = movie.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = movie.director,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

// Lista de películas para mostrar.
val movieList = listOf(
    Movie("El señor de los anillos", "Peter Jackson", R.drawable.lord),
    Movie("Seven Samurai", "Akira Kurosawa", R.drawable.seven),
    Movie("Ciudadano Kane","Orson Welles", R.drawable.kane),
    Movie("The Dark Cristal","David Odell and Frank Oz", R.drawable.dark),
    Movie("Willow","Ron Howard", R.drawable.willow),
    Movie("El mago de Oz","Victor Fleming", R.drawable.wizardoz),
    Movie("Dragonheart","Rob Cohen", R.drawable.dragon),
    Movie("Goodfellas","Martin Scorsese", R.drawable.good),
    Movie("Salvando al soldado Ryan","Steven Spielberg", R.drawable.ryan),
    Movie("El silencio de los corderos","Jonathan Demme", R.drawable.lambs),
    Movie("El Padrino","Francis Ford Coppola", R.drawable.padrino),
    Movie("Excalibur","John Boorman", R.drawable.excalibur)
)

/**
 * Pantalla que muestra una lista de películas en un diseño vertical.
 */
@Composable
fun MovieListScreen() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Recorre la lista de películas y genera filas para cada una.
        items(movieList) { movie ->
            MovieRow(movie = movie)
        }
    }
}

/**
 * Vista previa para fines de desarrollo y prueba.
 */
@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MisPeliculas20Theme {
        AppScaffold()
    }
}
