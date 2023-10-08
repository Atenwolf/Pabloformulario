package pablo.barra.formulario2

import java.util.Date

class Persona(
    val nombre: String,
    val apellido: String,
    val direccion: String,
    val edad: Int,
    val celular: Int,
    val fecha: Date,
    val activo: Boolean = true
)
