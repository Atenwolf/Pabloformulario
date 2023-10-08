package pablo.barra.formulario2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    private lateinit var btnGuardar: Button
    private lateinit var btnRegresar: Button
    private lateinit var tvDatos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresar = findViewById(R.id.btnRegresar)
        tvDatos = findViewById(R.id.tvDatos)

        val persona = intent.getSerializableExtra("persona") as Persona

        val datosStr = "Nombre: ${persona.nombre}\nApellido: ${persona.apellido}\nDirección: ${persona.direccion}\n" +
                "Edad: ${persona.edad}\nCelular: ${persona.celular}\nFecha: ${persona.fecha}\nMi Campo Booleano: ${persona.activo}"
        tvDatos.text = datosStr

        btnGuardar.setOnClickListener {

            Toast.makeText(this, "Datos guardados en la base de datos", Toast.LENGTH_SHORT).show()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}

