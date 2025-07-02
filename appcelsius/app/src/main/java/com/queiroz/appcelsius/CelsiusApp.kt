package com.queiroz.appcelsius

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.security.Key

@Preview
@Composable
fun CompCelsius(){
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf<String?>(null) }
    var kelvin by remember { mutableStateOf<String?>(null) }

    fun calcFahren() : String {
        val currentCelsius = celsius.toDoubleOrNull()

        if(currentCelsius != null) {
            val currentFahrenheit = (currentCelsius * (9/5)) + 32
            return "Fahrenheit: %2.1f".format(currentFahrenheit)
        }
        return "Coloque um valor valido"
    }

    fun calcKelvin() : String {
        val currentCelsius = celsius.toDoubleOrNull()

        if(currentCelsius != null) {
            val currentKelvin = currentCelsius + 273.15
            return "Kelvin: %2.1f".format(currentKelvin)
        }
        return "Coloque um valor valido"
    }

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            R.drawable.baseline_ac_unit_24),
            "Simbolo Floco De Neve",
            colorFilter = ColorFilter.tint(
                MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.size(64.dp)
        )

        Spacer(Modifier.height(8.dp))

        Text("Celsius", style = MaterialTheme.typography.displayLarge)

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = celsius,
            onValueChange = { celsius = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Celsius") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                fahrenheit = calcFahren()
                kelvin = calcKelvin()
            }
        ) {
            Text("Converter")
        }

        Spacer(Modifier.height(16.dp))

        fahrenheit?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(8.dp))

        kelvin?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium)
        }
    }
}