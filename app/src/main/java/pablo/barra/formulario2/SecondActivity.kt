package pablo.barra.formulario2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SecondActivity : AppCompatActivity() {
    private lateinit var nombreEditText: EditText
    private lateinit var apellidoEditText: EditText
    private lateinit var direccionEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var celularEditText: EditText
    private lateinit var fechaDatePicker: android.widget.DatePicker
    private lateinit var miCampoCheckBox: CheckBox
    private lateinit var guardarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nombreEditText = findViewById(R.id.editTextNombre)
        apellidoEditText = findViewById(R.id.editTextApellido)
        direccionEditText = findViewById(R.id.editTextdireccion)
        edadEditText = findViewById(R.id.editTextNumero)
        celularEditText = findViewById(R.id.editTextNumero1)
        fechaDatePicker = findViewById(R.id.datePicker)
        miCampoCheckBox = findViewById(R.id.checkBox)
        guardarButton = findViewById(R.id.botonAdelante)

        guardarButton.setOnClickListener {
            val nombreStr = nombreEditText.text.toString()
            val apellidoStr = apellidoEditText.text.toString()
            val direccionStr = direccionEditText.text.toString()
            val edadStr = edadEditText.text.toString()
            val celularStr = celularEditText.text.toString()

            val cal = Calendar.getInstance()
            cal.set(Calendar.YEAR, fechaDatePicker.year)
            cal.set(Calendar.MONTH, fechaDatePicker.month)
            cal.set(Calendar.DAY_OF_MONTH, fechaDatePicker.dayOfMonth)
            val fecha = cal.time

            val miCampoChecked = miCampoCheckBox.isChecked

            val edadInt = if (edadStr.isNotEmpty() && edadStr.matches(Regex("\\d+"))) {
                edadStr.toInt()
            } else {

                Toast.makeText(this, "Edad no válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mensaje =
                "Nombre: ${nombreStr}\nApellido: ${apellidoStr}\nDirección: ${direccionStr}\nEdad: ${edadInt}\nCelular: ${celularStr}\nFecha: ${SimpleDateFormat("dd/MM/yyyy", Locale.US).format(
                    fecha
                )}\nMi Campo Booleano: ${miCampoChecked}"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

        }
    }
}
