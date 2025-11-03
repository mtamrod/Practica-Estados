package com.example.practicaestados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.*

class Ejercicio2 : ComponentActivity() {
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
    var style by remember { mutableStateOf(ChainStyle.SpreadInside) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ActionsBar(chainStyle = style)

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { style = ChainStyle.Spread }) { Text("Spread") }
            Button(onClick = { style = ChainStyle.SpreadInside }) { Text("SpreadInside") }
            Button(onClick = { style = ChainStyle.Packed }) { Text("Packed") }
        }
    }
}

@Composable
private fun ActionsBar(
    modifier: Modifier = Modifier,
    chainStyle: ChainStyle = ChainStyle.SpreadInside,
    onExplore: () -> Unit = {},
    onFavorites: () -> Unit = {},
    onProfile: () -> Unit = {}
) {
    Surface {
        ConstraintLayout(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            val (explore, favorites, profile) = createRefs()

            Box {

            }
            Text(
                text = "Explorar",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .clickable { onExplore() }
                    .constrainAs(explore) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                    }
            )

            Text(
                text = "Favoritos",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .clickable { onFavorites() }
                    .constrainAs(favorites) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                    }
            )

            Text(
                text = "Perfil",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .clickable { onProfile() }
                    .constrainAs(profile) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                    }
            )

            // Cadena horizontal con estilo parametrizable
            createHorizontalChain(
                explore, favorites, profile,
                chainStyle = chainStyle
            )
        }
    }
}

/* ------- PREVIEWS ------- */

@Preview(showBackground = true, widthDp = 360, name = "SpreadInside")
@Composable
private fun PreviewInside() {
    MaterialTheme { ActionsBar(chainStyle = ChainStyle.SpreadInside) }
}

@Preview(showBackground = true, widthDp = 360, name = "Spread")
@Composable
private fun PreviewSpread() {
    MaterialTheme { ActionsBar(chainStyle = ChainStyle.Spread) }
}

@Preview(showBackground = true, widthDp = 360, name = "Packed")
@Composable
private fun PreviewPacked() {
    MaterialTheme { ActionsBar(chainStyle = ChainStyle.Packed) }
}
