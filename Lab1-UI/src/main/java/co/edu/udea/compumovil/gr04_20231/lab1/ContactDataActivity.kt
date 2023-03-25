package co.edu.udea.compumovil.gr04_20231.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class ContactDataActivity : AppCompatActivity() {

    lateinit var autoCountry:AutoCompleteTextView
    lateinit var autoCities:AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoCountry =  findViewById<AutoCompleteTextView>(R.id.countryAutoComplete)
        autoCities =  findViewById<AutoCompleteTextView>(R.id.cityAutoComplete)
        setContentView(R.layout.activity_contact_data)

        val countries = resources.getStringArray(R.array.listaPaises)
        val adapterCountries = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries)
        autoCountry.setAdapter(adapterCountries)

        val cities = resources.getStringArray(R.array.listaCiudades)
        val adapterCities = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities)
        autoCities.setAdapter(adapterCities)

        val myButton = findViewById<Button>(R.id.nextButton)
        myButton.setOnClickListener {
            val editPhone = findViewById<EditText>(R.id.phoneEditText)
            val editMail = findViewById<EditText>(R.id.mailEditText)


            if (editPhone.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.toastMessagePhone),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (editMail.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.toastMessageMail),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (autoCountry.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.toastMessageCountry),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                imprimir()
            }
        }
    }

    fun imprimir() {
        // Obtener los objetos
        val editTextPhone = findViewById<EditText>(R.id.phoneEditText)
        val editTextMail = findViewById<EditText>(R.id.mailEditText)
        val autocompleteCountry = findViewById<AutoCompleteTextView>(R.id.countryAutoComplete)
        val autocompleteCity = findViewById<AutoCompleteTextView>(R.id.cityAutoComplete)
        val editTextAdress = findViewById<EditText>(R.id.adressEditText)

        // Guardar textos de los objetos
        val phone = editTextPhone.text.toString()
        val mail = editTextMail.text.toString()
        val country = autocompleteCountry.text.toString()
        val city = autocompleteCity.text.toString()
        val adress = editTextAdress.text.toString()

        // Imprimir en consola
        Log.d("IC", "Información de contacto:")
        Log.d("IC", "Teléfono: $phone")
        Log.d("IC", "Dirección: $adress")
        Log.d("IC", "Email: $mail")
        Log.d("IC", "Pais: $country")
        Log.d("IC", "Ciudad: $city")

    }
}