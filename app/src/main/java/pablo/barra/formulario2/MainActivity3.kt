package pablo.barra.formulario2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    private var btnGuardar: Button? = null
    private var btnRegresar: Button? = null
    private var tvDatos: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3) // Asegúrate de que el nombre del layout sea correcto (activity_main3.xml)

        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresar = findViewById(R.id.btnRegresar)
        tvDatos = findViewById(R.id.tvDatos)

        btnGuardar?.setOnClickListener(View.OnClickListener {
        })

        btnRegresar?.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}