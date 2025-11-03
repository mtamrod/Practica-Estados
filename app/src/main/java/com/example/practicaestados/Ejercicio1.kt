package com.example.practicaestados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*

class Ejercicio1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = Color(0xFFF5F5F5)) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        ProductCard(
                            title = "Auriculares inalámbricos con cancelación de ruido",
                            price = "89,99 €"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(title: String, price: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val (image, titleRef, priceRef, buttonRef) = createRefs()

            val buttonGuide = createGuidelineFromEnd(120.dp)

            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(80.dp)
                    height = Dimension.value(80.dp)
                }
            )

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end, margin = 12.dp)
                    end.linkTo(buttonGuide)                 // ← aquí
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(priceRef) {
                    top.linkTo(titleRef.bottom, margin = 4.dp)
                    start.linkTo(image.end, margin = 12.dp)
                    end.linkTo(buttonGuide)                 // ← aquí también
                    width = Dimension.fillToConstraints
                }
            )

            val textBarrier = createEndBarrier(titleRef, priceRef)

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.constrainAs(buttonRef) {
                    // Usa la guideline para garantizar hueco visible
                    start.linkTo(buttonGuide, margin = 12.dp)
                    end.linkTo(parent.end)
                    top.linkTo(titleRef.top)
                    bottom.linkTo(priceRef.bottom)
                    width = Dimension.wrapContent
                }
            ) {
                Text("Comprar", maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

/* ----------- PREVIEWS ----------- */

@Preview(showBackground = true, widthDp = 380, name = "Título corto")
@Composable
fun PreviewShortTitle() {
    MaterialTheme {
        ProductCard(title = "Auriculares", price = "19,99 €")
    }
}

@Preview(showBackground = true, widthDp = 380, name = "Título largo")
@Composable
fun PreviewLongTitle() {
    MaterialTheme {
        ProductCard(
            title = "Auriculares inalámbricos con cancelación de ruido",
            price = "89,99 €"
        )
    }
}
