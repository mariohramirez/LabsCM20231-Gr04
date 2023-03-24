package co.edu.udea.compumovil.gr04_20231.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText

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
    }
}