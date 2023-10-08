package pablo.barra.formulario2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var viewButton: Button
    private lateinit var editButton: Button
    private lateinit var deleteButton: Button
    private lateinit var adapter: ArrayAdapter<String>


    private val itemList = arrayListOf("Elemento 1", "Elemento 2", "Elemento 3")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listView = findViewById(R.id.listView)
        viewButton = findViewById(R.id.viewButton)
        editButton = findViewById(R.id.editButton)
        deleteButton = findViewById(R.id.deleteButton)


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter


        listView.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, position, _ ->

            val selectedItem = itemList[position]
            Toast.makeText(this, "Elemento seleccionado: $selectedItem", Toast.LENGTH_SHORT).show()
        })


        viewButton.setOnClickListener(View.OnClickListener {
            val selectedItem = listView.selectedItem
            if (selectedItem != null) {
                Toast.makeText(this, "Ver: $selectedItem", Toast.LENGTH_SHORT).show()
            }
        })

        editButton.setOnClickListener(View.OnClickListener {
            val selectedItem = listView.selectedItem
            if (selectedItem != null) {
                Toast.makeText(this, "Editar: $selectedItem", Toast.LENGTH_SHORT).show()
            }
        })

        deleteButton.setOnClickListener(View.OnClickListener {
            val selectedItem = listView.selectedItem
            if (selectedItem != null) {
                itemList.remove(selectedItem)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Eliminar: $selectedItem", Toast.LENGTH_SHORT).show()
            }
        })
    }
}