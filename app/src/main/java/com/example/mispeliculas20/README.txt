Modifiers generales:
    Modificadores basicos:
        padding
        Agrega espacio alrededor del contenido.
        Modifier.padding(16.dp)

        size
        Establece el tamaño del elemento.
        Modifier.size(100.dp)

        width / height
        Especifica el ancho o alto del elemento.
        Modifier.width(100.dp).height(50.dp)

        fillMaxSize / fillMaxWidth / fillMaxHeight
        Hace que el elemento ocupe el tamaño máximo disponible en su contenedor.
        Modifier.fillMaxSize()

        aspectRatio
        Define la relación de aspecto del elemento.
        Modifier.aspectRatio(1f)

    Modificadores de posicion:
        offset
        Desplaza el elemento desde su posición original.
        Modifier.offset(10.dp, 20.dp)

        zIndex
        Cambia la prioridad en el eje Z.
        Modifier.zIndex(1f)

    Modificadores de fondo y forma
        background
        Agrega un fondo al elemento.
        Modifier.background(Color.Red)

        clip
        Recorta el elemento en una forma específica.
        Modifier.clip(RoundedCornerShape(8.dp))

        border
        Agrega un borde al elemento.
        Modifier.border(2.dp, Color.Black)

    Modificadores para alineacion
        align
        Define la alineación dentro de un contenedor.
        Modifier.align(Alignment.Center)

        wrapContentSize
        Hace que el tamaño del elemento se ajuste a su contenido, con una alineación opcional.
        Modifier.wrapContentSize(Alignment.TopStart)

    Modificadores para gestos y entrada
        clickable
        Hace que el elemento sea clickeable.
        Modifier.clickable { /* Acción */ }

        pointerInput
        Configura gestos personalizados.
        Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = { /* Acción */ })
        }

        draggable
        Agrega funcionalidad de arrastre.
        Modifier.draggable(/* Configuración */)

        scrollable
        Permite el desplazamiento.
        Modifier.scrollable(/* Configuración */)

    Modificadores para texto
        semantics
        Proporciona información accesible para lectores de pantalla.
        Modifier.semantics { contentDescription = "Botón de ejemplo" }

        drawBehind
        Permite personalizar el dibujo detrás del elemento.
        Modifier.drawBehind {
            drawCircle(Color.Blue, radius = 50f)
        }

    Otros modificadores útiles
        alpha
        Ajusta la opacidad del elemento.
        Modifier.alpha(0.5f)

        shadow
        Agrega una sombra al elemento.
        Modifier.shadow(8.dp)

        then
        Combina modificadores, útil para composables más complejos.
        Modifier.padding(8.dp).then(Modifier.shadow(4.dp))

    Cadena de Modificadores
        Los modificadores se pueden encadenar para construir un diseño detallado:
        Modifier
            .padding(16.dp)
            .background(Color.Gray)
            .clip(RoundedCornerShape(8.dp))
            .size(120.dp)
            .clickable { /* Acción */ }




Elementos:
    Text
        Basico
            color
            Cambia el color del texto.
            Text(
                text = "Hola, Jetpack Compose",
                color = Color.Red
            )

            fontSize
            Define el tamaño de la fuente.
            Text(
                text = "Texto grande",
                fontSize = 24.sp
            )

            fontWeight
            Cambia el grosor de la fuente.
            Text(
                text = "Texto en negrita",
                fontWeight = FontWeight.Bold
            )

            fontStyle
            Cambia el estilo de la fuente (por ejemplo, itálica).
            Text(
                text = "Texto en itálica",
                fontStyle = FontStyle.Italic
            )

            fontFamily
            Define la familia tipográfica.
            Text(
                text = "Texto con fuente personalizada",
                fontFamily = FontFamily.Serif
            )

            letterSpacing
            Ajusta el espacio entre letras.
            Text(
                text = "Espaciado entre letras",
                letterSpacing = 2.sp
            )

            lineHeight
            Cambia la altura de las líneas de texto.
            Text(
                text = "Texto con altura de línea",
                lineHeight = 20.sp
            )

            textDecoration
            Aplica subrayado o tachado al texto.
            Text(
                text = "Texto subrayado",
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = "Texto tachado",
                textDecoration = TextDecoration.LineThrough
            )

            textAlign
            Cambia la alineación del texto dentro de su contenedor.
            Text(
                text = "Texto centrado",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            overflow
            Controla cómo manejar el texto que excede el espacio disponible.
            Text(
                text = "Texto que se corta...",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            softWrap
            Define si el texto debe ajustarse al ancho del contenedor.
            Text(
                text = "Texto que no se ajusta al contenedor",
                softWrap = false
            )

            maxLines
            Limita el número máximo de líneas que puede tener el texto.
            Text(
                text = "Este texto solo tiene dos líneas permitidas.",
                maxLines = 2
            )

        Avanzado
            shadow
            Agrega una sombra al texto.
            Text(
                text = "Texto con sombra",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                )
            )

            background
            Establece un color de fondo detrás del texto.
            Text(
                text = "Texto con fondo",
                modifier = Modifier.background(Color.Yellow)
            )

    Box
        contentAlignment
        Establece la alineación predeterminada de los hijos dentro del Box.
        Box(
            modifier = Modifier.size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Centrado")
        }

        propagateMinConstraints
        Indica si las restricciones mínimas del Box deben aplicarse a sus hijos.
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray),
            propagateMinConstraints = true
        ) {
            Text("Restringido al mínimo")
        }

    Column
        verticalArrangement
        Controla cómo se distribuyen los hijos verticalmente dentro del Column.
        Ejemplos comunes:
            Arrangement.Top: Los hijos se alinean en la parte superior.
            Arrangement.Center: Los hijos se centran verticalmente.
            Arrangement.SpaceBetween: El espacio disponible se distribuye uniformemente entre los hijos.
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Elemento 1")
            Text("Elemento 2")
        }

        horizontalAlignment
        Define cómo se alinean los hijos horizontalmente dentro del Column.
        Ejemplos comunes:
            Alignment.Start: Alinea los hijos al inicio del eje horizontal.
            Alignment.CenterHorizontally: Centra los hijos horizontalmente.
            Alignment.End: Alinea los hijos al final del eje horizontal.
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Centrado horizontalmente")
        }

    Row
        horizontalArrangement
        Controla cómo se distribuyen los hijos a lo largo del eje horizontal dentro del Row.
        Ejemplos comunes:
            Arrangement.Start: Alinea los hijos al inicio.
            Arrangement.Center: Centra los hijos horizontalmente.
            Arrangement.SpaceBetween: Distribuye uniformemente el espacio entre los hijos.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Elemento 1")
            Text("Elemento 2")
        }

        verticalAlignment
        Define cómo se alinean los hijos verticalmente dentro del Row.
        Ejemplos comunes:
            Alignment.Top: Alinea los hijos en la parte superior.
            Alignment.CenterVertically: Centra los hijos verticalmente.
            Alignment.Bottom: Alinea los hijos en la parte inferior.
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Texto centrado verticalmente")
        }

    Imágenes (en Internet y locales): Bitmap y vectoriales
        Imagenes locales
            Usar recursos de imagen (drawable)
            Utiliza el composable Image con painterResource para cargar imágenes desde los recursos locales.
            @Composable
            fun LocalImage() {
                Image(
                    painter = painterResource(id = R.drawable.my_image),
                    contentDescription = "Imagen local",
                    modifier = Modifier.size(100.dp)
                )
            }

            Usar imágenes vectoriales
            Para imágenes vectoriales como SVG o VectorDrawable, también se utiliza painterResource. Estas imágenes se escalan sin pérdida de calidad.
            @Composable
            fun VectorImage() {
                Image(
                    painter = painterResource(id = R.drawable.my_vector),
                    contentDescription = "Imagen vectorial",
                    modifier = Modifier.size(100.dp)
                )
            }

        Imagenes de internet
            Usar librerías externas (como Coil)
            Para cargar imágenes desde URLs, se recomienda usar librerías como Coil, que es compatible con Jetpack Compose.

            Agrega la dependencia en el archivo build.gradle:
            implementation("io.coil-kt:coil-compose:2.2.2")

            Usa AsyncImage para cargar imágenes desde Internet:
            import coil.compose.AsyncImage

            @Composable
            fun NetworkImage() {
                AsyncImage(
                    model = "https://example.com/image.png",
                    contentDescription = "Imagen desde URL",
                    modifier = Modifier.size(100.dp)
                )
            }

            Personalización de carga con Coil
            Puedes agregar configuraciones como indicadores de carga, manejo de errores y lugar de espera (placeholder).
            @Composable
            fun CustomizedNetworkImage() {
                AsyncImage(
                    model = "https://example.com/image.png",
                    contentDescription = "Imagen con personalización",
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.error),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }

        Imagenes Bitmap
            Cargar un Bitmap desde recursos
            Puedes usar BitmapFactory para convertir imágenes en recursos a bitmaps y mostrarlas con BitmapPainter.
            @Composable
            fun BitmapImage() {
                val bitmap = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.my_bitmap)
                Image(
                    painter = BitmapPainter(bitmap.asImageBitmap()),
                    contentDescription = "Imagen Bitmap",
                    modifier = Modifier.size(100.dp)
                )
            }

            Cargar un Bitmap desde un archivo
            Para cargar un bitmap desde un archivo del almacenamiento:
            @Composable
            fun FileBitmapImage(file: File) {
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                Image(
                    painter = BitmapPainter(bitmap.asImageBitmap()),
                    contentDescription = "Imagen desde archivo",
                    modifier = Modifier.size(100.dp)
                )
            }

        Modificadores
            size
            Especifica el tamaño de la imagen.
            modifier = Modifier.size(150.dp)

            clip
            Recorta la imagen con una forma específica.
            modifier = Modifier.clip(RoundedCornerShape(16.dp))

            border
            Agrega un borde alrededor de la imagen.
            modifier = Modifier.border(2.dp, Color.Black)

            contentScale
            Controla cómo la imagen se escala dentro de su contenedor:
                ContentScale.Crop: Recorta la imagen para llenar el contenedor.
                ContentScale.Fit: Ajusta la imagen para que quepa dentro del contenedor sin recortar.
                ContentScale.FillBounds: Estira la imagen para llenar todo el contenedor.
            contentScale = ContentScale.Crop

            alpha
            Ajusta la transparencia de la imagen.
            modifier = Modifier.alpha(0.5f)

            shadow
            Agrega una sombra a la imagen.
            modifier = Modifier.shadow(8.dp, CircleShape)

    Iconos (PNG y SVG)
        PNG
            Iconos PNG desde recursos locales
            Para usar un icono en formato PNG desde los recursos locales, puedes utilizar el composable Image junto con painterResource, como en el caso de imágenes tradicionales.
            @Composable
            fun PngIcon() {
                Image(
                    painter = painterResource(id = R.drawable.my_icon_png),
                    contentDescription = "Icono PNG",
                    modifier = Modifier.size(48.dp)
                )
            }
            En este ejemplo, R.drawable.my_icon_png es el archivo PNG que has colocado en la carpeta res/drawable.

            Modificadores aplicables
            Puedes aplicar modificadores comunes a los iconos PNG, como tamaño, recorte, borde, etc.
            Image(
                painter = painterResource(id = R.drawable.my_icon_png),
                contentDescription = "Icono PNG",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray)
            )

        SVG
            Usar iconos SVG de recursos locales
            Si tienes un icono SVG en los recursos, puedes utilizar painterResource y cargarlo como un vector. Jetpack Compose maneja automáticamente los archivos SVG con painterResource.
            @Composable
            fun SvgIcon() {
                Image(
                    painter = painterResource(id = R.drawable.my_icon_svg),
                    contentDescription = "Icono SVG",
                    modifier = Modifier.size(48.dp)
                )
            }

            Usar iconos SVG con ImageVector
            Jetpack Compose incluye una serie de iconos predefinidos a través de Icons que puedes usar directamente sin necesidad de archivos externos. Algunos iconos como los de Material Design ya están disponibles en Compose y puedes usarlos con Icon o Image.
            @Composable
            fun MaterialDesignIcon() {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Icono Material Design",
                    modifier = Modifier.size(48.dp)
                )
            }
            Este ejemplo utiliza el icono Favorite de Material Icons.

            Modificadores aplicables a iconos SVG
            Los iconos SVG también se pueden modificar con varios modificadores, como size, padding, contentDescription, tint, etc.
                tint: Cambia el color del icono.
                size: Ajusta el tamaño del icono.
            @Composable
            fun TintedSvgIcon() {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Icono tintado",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp),
                    tint = Color.Red // Cambia el color del icono
                )
            }

    Scaffold
        Estrucutura basica
            Scaffold(
                topBar = {
                    // Barra superior (ej. AppBar)
                },
                bottomBar = {
                    // Barra inferior (ej. BottomNavigation)
                },
                floatingActionButton = {
                    // Botón flotante
                },
                drawerContent = {
                    // Contenido del Drawer (menú lateral)
                },
                content = { paddingValues ->
                    // Contenido principal
                    Column(modifier = Modifier.padding(paddingValues)) {
                        Text(text = "Contenido de la pantalla")
                    }
                }
            )

        Modificadores
            El parámetro content recibe un PaddingValues que puedes usar para ajustar el contenido en función de las áreas reservadas por otros elementos del Scaffold (como la topBar o bottomBar).

            padding: El contenido se debe ajustar para no quedar cubierto por la barra superior o la barra inferior. Puedes usar Modifier.padding con los valores proporcionados en paddingValues.
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Mi App") }
                    )
                },
                content = { paddingValues ->
                    // Asegura que el contenido no quede debajo de la top bar
                    Column(modifier = Modifier.padding(paddingValues)) {
                        Text(text = "Este es el contenido de la pantalla")
                    }
                }
            )

            fillMaxSize: Hace que el contenido ocupe todo el espacio disponible.
            Scaffold(
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize() // Contenido ocupa todo el tamaño disponible
                    ) {
                        Text(text = "Contenido principal")
                    }
                }
            )

    Barra superior
        La barra superior (topBar) se usa para colocar el título y las acciones principales de la app. Aquí puedes aplicar varios modificadores para personalizar la apariencia.
            backgroundColor: Cambia el color de fondo de la barra superior.
            elevation: Agrega sombra a la barra superior.
            contentPadding: Controla el espaciado interno de la barra.
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mi App") },
                    backgroundColor = Color.Blue, // Color de fondo
                    elevation = 8.dp, // Sombra de la barra
                    contentPadding = PaddingValues(16.dp) // Espaciado interno
                )
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Text("Contenido principal")
                }
            }
        )

    Barra inferior
        Similar a la barra superior, la barra inferior (bottom bar) se usa para agregar elementos como la navegación de la aplicación.
            backgroundColor: Cambia el color de fondo de la barra inferior.
            elevation: Agrega sombra a la barra inferior.
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    backgroundColor = Color.Gray, // Color de fondo
                    elevation = 10.dp // Sombra
                ) {
                    // Agrega iconos o botones dentro de la barra inferior
                    IconButton(onClick = { /* Acción */ }) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                }
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Text("Contenido principal")
                }
            }
        )

    FAB (Botón de Acción Flotante)
        El botón flotante se usa para mostrar una acción destacada, como agregar un nuevo elemento. Puedes modificar su posición, tamaño y otros atributos visuales.
            onClick: Establece la acción que se ejecuta cuando el botón es presionado.
            modifier: Usar modificadores como size, padding, alignment, etc.
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Acción del botón */ },
                    backgroundColor = Color.Green, // Cambia el color de fondo
                    contentColor = Color.White // Cambia el color del contenido
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar")
                }
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Text("Contenido principal")
                }
            }
        )

    Drawer
        El Drawer permite agregar un menú lateral deslizante. Puedes modificar su contenido con diversos modificadores.
            drawerContent: Define el contenido del Drawer (menú lateral).
            drawerShape: Cambia la forma del Drawer (puedes hacerlo redondeado o cuadrado).
            drawerBackgroundColor: Establece el color de fondo del Drawer.
        Scaffold(
            drawerContent = {
                Column {
                    Text("Opción 1")
                    Text("Opción 2")
                }
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Text("Contenido principal")
                }
            }
        )

    Lazycolumn
        Tamaño: fillMaxSize(), height(), wrapContentHeight(), width()
        Alineación y disposición: verticalArrangement, horizontalAlignment, reverseLayout
        Desplazamiento: verticalScroll, nestedScroll
            Modificadores de Scroll
            verticalScroll: Habilita el desplazamiento vertical.
            LazyColumn(
                modifier = Modifier.verticalScroll(rememberScrollState()) // Activa el desplazamiento
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }

            nestedScroll: Permite manejar el desplazamiento de forma personalizada, por ejemplo, con una barra de desplazamiento anidada.
            LazyColumn(
                modifier = Modifier.nestedScroll(rememberNestedScrollConnection()) // Para desplazamiento anidado
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }
        Espaciado: padding, contentPadding
        Estilo visual: background, clip, shadow, animateItemPlacement
        Comportamiento y animaciones: animateContentSize(), snapToItem()

    Lazyrow
        Tamaño: fillMaxWidth(), height(), wrapContentHeight(), width()
        Alineación y disposición: horizontalArrangement, verticalAlignment, reverseLayout
            horizontalArrangement: Controla la disposición horizontal de los elementos. Por ejemplo, Arrangement.spacedBy() puede añadir espacio entre los ítems.
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio de 8 dp entre los elementos
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }

            verticalAlignment: Controla la alineación vertical de los elementos dentro del LazyRow.
            LazyRow(
                verticalAlignment = Alignment.CenterVertically // Alinea los ítems verticalmente al centro
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }
        Desplazamiento: horizontalScroll, nestedScroll
            horizontalScroll: Activa el desplazamiento horizontal, aunque generalmente no es necesario en un LazyRow ya que se desplazará automáticamente.
            LazyRow(
                modifier = Modifier.horizontalScroll(rememberScrollState()) // Desplazamiento horizontal manual
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }

            nestedScroll: Permite manejar un comportamiento de desplazamiento personalizado, útil cuando se tiene un LazyRow dentro de otros elementos con desplazamiento.
            LazyRow(
                modifier = Modifier.nestedScroll(rememberNestedScrollConnection()) // Desplazamiento anidado
            ) {
                items(100) { index ->
                    Text(text = "Elemento $index")
                }
            }
        Espaciado: padding, contentPadding
        Estilo visual: background, clip, shadow, animateItemPlacement
        Comportamiento y animaciones: animateContentSize(), snapToItem()

UI Tree
