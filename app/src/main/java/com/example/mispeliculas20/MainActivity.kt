package com.example.mispeliculas20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MisPeliculas20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CustomScaffold()
                }
            }
        }
    }
}

// Define una función Composable que usa el componente Scaffold para crear una pantalla estructurada
// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold() {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    var expanded by remember { mutableStateOf(false) } // Controla si el menú está desplegado
    TopAppBar(
        // Colores personalizados para la barra superior
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF009688), // Color de fondo
            titleContentColor = Color.White, // Color del texto del título
            navigationIconContentColor = Color.White, // Color del icono de navegación
            actionIconContentColor = Color.White // Color de los iconos de acción
        ),
        // Título de la barra superior
        title = {
            // Contenedor para centrar el texto
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(text = "Mis Películas") // Texto centrado
            }
        },
        navigationIcon = {
            // Ícono del menú desplegable a la izquierda
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú desplegable"
                )
            }
        },
        actions = {
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Opción 1") },
            onClick = { expanded = false } // Acciones si se selecciona algo
        )
        DropdownMenuItem(
            text = { Text("Opción 2") },
            onClick = { expanded = false }
        )
        DropdownMenuItem(
            text = { Text("Opción 3") },
            onClick = { expanded = false }
        )
    }
}

@Composable
fun CustomBottomBar() {
    BottomAppBar(
        containerColor = Color(0xFF009688), // Cambiar el color de fondo
        contentColor = Color.White // Cambiar el color de los íconos
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon (
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = null
                )
            }
            FloatingActionButton(onClick = {/*TODO*/},shape= MaterialTheme.shapes.extraLarge) {
                IconButton(onClick = {/*TODO*/}) {
                    Icon (
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            FilmListScreen()
        }
    )
}

// Step 1: Data class to hold fruit details
data class FilmModel(val name: String, val director: String, val image: Int)

// Step 2: Custom row to display each fruit
@Composable
fun ListRow(model: FilmModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color(0xFF063041)) // Using hexadecimal color
    ) {
        Column () {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
        }
        Column () {
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = model.director,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

// Step 3 and 4: Fruit list initialization
val fruitsList = mutableListOf(
    FilmModel("El señor de los anillos","Peter Jackson", R.drawable.lord),
    FilmModel("Seven Samurai","Akira Kurosawa", R.drawable.seven),
    FilmModel("Ciudadano Kane","Orson Welles", R.drawable.kane),
    FilmModel("The Dark Cristal","David Odell and Frank Oz", R.drawable.dark),
    FilmModel("Willow","Ron Howard", R.drawable.willow),
    FilmModel("El mago de Oz","Victor Fleming", R.drawable.wizardoz),
    FilmModel("Dragonheart","Rob Cohen", R.drawable.dragon),
    FilmModel("Goodfellas","Martin Scorsese", R.drawable.good),
    FilmModel("Salvando al soldado Ryan","Steven Spielberg", R.drawable.ryan),
    FilmModel("El silencio de los corderos","Jonathan Demme", R.drawable.lambs),
    FilmModel("El Padrino","Francis Ford Coppola", R.drawable.padrino),
    FilmModel("Excalibur","John Boorman", R.drawable.excalibur),

    )

// Step 5: LazyColumn to display the list
@Composable
fun FilmListScreen() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MisPeliculas20Theme {
        CustomScaffold()
    }
}