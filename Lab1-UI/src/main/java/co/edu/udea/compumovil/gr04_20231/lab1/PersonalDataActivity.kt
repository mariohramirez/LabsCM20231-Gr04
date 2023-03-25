package co.edu.udea.compumovil.gr04_20231.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import co.edu.udea.compumovil.gr04_20231.lab1.R.string.*

class PersonalDataActivity : AppCompatActivity() {

    private lateinit var dateVar:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dateVar =findViewById<EditText>(R.id.dateSelectTextView)
        setContentView(R.layout.activity_personal_data)


        dateVar.setOnClickListener {
            showPickerDialog()
        }

        val myButton = findViewById<Button>(R.id.nextButton)
        myButton.setOnClickListener{
            val editName = findViewById<EditText>(R.id.nameEditText)
            val editLastName = findViewById<EditText>(R.id.lastNameEditText)
            val editDate = findViewById<TextView>(R.id.dateTextview)


            if (editName.text.toString().isEmpty()) {
                Toast.makeText(this, resources.getString(toastMessageName), Toast.LENGTH_SHORT).show()
            } else if (editLastName.toString().isEmpty()){
                Toast.makeText(this, resources.getString(toastMessageLastName), Toast.LENGTH_SHORT).show()
            } else if (editDate.text.toString()== resources.getString(seleccionaFecha)) {
                Toast.makeText(this, resources.getString(toastMessageDate), Toast.LENGTH_SHORT).show()
            } else {
                imprimir()
                val intent = Intent(this, ContactDataActivity::class.java)
                startActivity(intent)
            }
        }


    }

    private fun showPickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        dateVar.setText("$day/$month/$year")
    }

    fun imprimir() {
        // Obtener los objetos
        val editName = findViewById<EditText>(R.id.nameEditText)
        val editLastName = findViewById<EditText>(R.id.lastNameEditText)
        val radioGroup = findViewById<RadioGroup>(R.id.sexContainer)
        val select = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(select)
        val editDate = findViewById<TextView>(R.id.dateTextview)
        val spinnerGrade = findViewById<Spinner>(R.id.schoolSpinner)

        // Guardar textos d los objetos
        val name = editName.text.toString()
        val lastName = editLastName.text.toString()
        val sex = radioButton.text.toString()
        val date = editDate.text.toString()
        val grade = spinnerGrade.selectedItem.toString()

        // Imprimir en consola
        Log.d("IP", "Información Personal:")
        Log.d("IP", "$name $lastName")
        Log.d("IP", sex)
        Log.d("IP", "Nació el $date")
        Log.d("IP", grade)
    }

}