package com.example.practicaestados

import android.R
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.*
import kotlin.math.sign

class Ejercicio4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    pantallaEstilos()
                }
            }
        }
    }
}

@Composable
private fun pantallaEstilos() {

    var resultado by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black)
                    .size(75.dp),

                contentAlignment = Alignment.Center
            ) {
                Text(
                    resultado.toString(),
                    fontSize = 40.sp,
                    color = Color.White
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { resultado = operaciones(resultado, "-") }) { Text("-") }
            Button(onClick = { resultado = operaciones(resultado, "+") }) { Text("+") }
        }
    }
}

fun operaciones(resultado: Int, signo: String): Int {

    var resultadoOperacion = resultado

    if (signo == "-") {
        if (resultado > 0) {
            --resultadoOperacion
        }

        error("No se puede restar menos que 0")

    } else if (signo == "+") {
        ++resultadoOperacion
    } else {
        error("Signo no válido: $signo")
    }

    return resultadoOperacion
}
