package pablo.barra.formulariopablobarra

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class Bdatos(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {
    companion object {
        private const val NAME = "bdatos.db"
        private const val VERSION = 1
        private const val TABLE_NAME = "Personas"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOM = "nom"
        private const val COLUMN_APELL = "apell"
        private const val COLUMN_DIR = "dir"
        private const val COLUMN_EDAD = "edad"
        private const val COLUMN_CEL = "cel"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_BOOLEAN = "activo"
    }
    override fun onCreate(db: SQLiteDatabase) {
        val createTableSQL = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NOM TEXT," +
                "$COLUMN_APELL TEXT," +
                "$COLUMN_DIR TEXT," +
                "$COLUMN_EDAD INTEGER," +
                "$COLUMN_CEL INTEGER," +
                "$COLUMN_DATE DATE," +
                "$COLUMN_BOOLEAN INTEGER" +
                ")"
        db.execSQL(createTableSQL)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    // Operación de inserción
    fun insertData(nom: String, apell: String, dir: String, edad: Int, cel: Int, date: String, activo: Boolean): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NOM, nom)
        values.put(COLUMN_APELL, apell)
        values.put(COLUMN_DIR, dir)
        values.put(COLUMN_EDAD, edad)
        values.put(COLUMN_CEL, cel)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)
        val newRowId = db.insert(TABLE_NAME, null, values)
        db.close()
        return newRowId
    }
    // Operación de lectura
    fun getAllData(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
    // Operación de actualización
    fun updateData(id: Long, nom: String, apell: String, dir: String, edad: Int, cel: Int, date: String, activo: Boolean): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NOM, nom)
        values.put(COLUMN_APELL, apell)
        values.put(COLUMN_DIR, dir)
        values.put(COLUMN_EDAD, edad)
        values.put(COLUMN_CEL, cel)
        values.put(COLUMN_DATE, date)
        values.put(COLUMN_BOOLEAN, if (activo) 1 else 0)
        val rowsAffected = db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }
}