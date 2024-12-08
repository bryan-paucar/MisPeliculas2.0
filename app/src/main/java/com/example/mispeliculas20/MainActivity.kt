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
                AppScaffold()
            }
        }
    }
}

/**
 * Estructura principal de la aplicación.
 *
 * Incluye:
 * - Una barra superior (`AppTopBar`) que contiene el título de la app y botones de acciones.
 * - Una barra inferior (`AppBottomBar`) con botones de interacción y un botón flotante.
 * - Un área para el contenido principal (`AppContent`), ajustado al espacio restante.
 *
 * Cómo funciona el `padding` en `Scaffold`:
 * 1. El `Scaffold` calcula el espacio reservado para sus componentes (como `topBar`, `bottomBar`, etc.).
 * 2. Proporciona este cálculo en forma de un objeto `PaddingValues` a través del lambda del parámetro `content`.
 * 3. Es responsabilidad del contenido principal (en este caso, `AppContent`) aplicar explícitamente este `PaddingValues`
 *    a través de su `Modifier` para respetar el espacio reservado.
 *
 * Nota:
 * - `AppContent` recibe el `PaddingValues` calculado por el `Scaffold` pero no aplica automáticamente el espaciado.
 * - El diseño final del contenido depende de que el `padding` se maneje correctamente dentro de `AppContent`.
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
            // Pasa el padding calculado al contenido principal para que lo respete explícitamente.
            AppContent(padding)
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
 * Contenido principal de la aplicación, ajustado al espacio disponible y muestra una lista de películas.
 *
 * @param padding Espaciado interno proporcionado por el `Scaffold`, que se debe aplicar explícitamente
 *                a los elementos para que respeten el espacio reservado por las barras superior e inferior.
 *
 * Nota:
 * - El `Scaffold` no aplica automáticamente el `padding` a los elementos dentro de su contenido. Solo calcula
 *   el espacio necesario para sus componentes (`topBar`, `bottomBar`, etc.) y lo pasa como un objeto `PaddingValues`.
 *   Es responsabilidad del desarrollador aplicar este `padding` mediante `.padding(padding)` a los elementos contenidos.
 *
 * - El uso de un `Column` es opcional y útil si se necesita trabajar con múltiples elementos dentro de `AppContent`.
 *   En ese caso, el `padding` del `Scaffold` debe aplicarse al `Column`.
 *
 * - Al pasar el `padding` como parte del `Modifier` de `MovieListScreen`, nos aseguramos de que la lista respete
 *   el espacio reservado por el `Scaffold`. También es importante que los elementos dentro de `MovieListScreen`
 *   usen el `modifier` proporcionado y no creen uno nuevo.
 */
@Composable
fun AppContent(padding: PaddingValues) {
    MovieListScreen(
        modifier = Modifier
            .fillMaxSize() // Asegura que la lista ocupe todo el espacio restante.
            .padding(padding) // Aplica el padding calculado por el Scaffold.
    )
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
 *
 * @param modifier Modificador que se aplica al contenedor principal (`LazyColumn`), permitiendo que
 *                 esta función respete configuraciones externas, como el padding del `Scaffold`.
 *
 * Nota:
 * - El `contentPadding` se usa para que los elementos hijos respeten un padding interno (horizontal y vertical).
 * - Anteriormente, un `Modifier` nuevo reemplazaba al `modifier` proporcionado como parámetro, lo que
 *   ignoraba configuraciones externas como el padding definido en su llamada desde `AppContent`:
 *   `MovieListScreen(modifier = Modifier.fillMaxSize().padding(padding))`.
 *   Esto ha sido corregido, y ahora el `modifier` proporcionado se utiliza correctamente, combinado con otros
 *   modificadores locales (`fillMaxSize`, `background`).
 */
@Composable
fun MovieListScreen(modifier: Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), //Los elementos hijos respetaran este padding
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
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
