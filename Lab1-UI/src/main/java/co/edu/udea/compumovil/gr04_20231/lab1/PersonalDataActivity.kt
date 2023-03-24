package co.edu.udea.compumovil.gr04_20231.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class PersonalDataActivity : AppCompatActivity() {

    lateinit var dateVar:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dateVar =findViewById<EditText>(R.id.dateSelectTextView)
        setContentView(R.layout.activity_personal_data)

        dateVar.setOnClickListener {
            showPickerDialog()
        }


    }

    private fun showPickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        dateVar.setText("$day/$month/$year")
    }
}