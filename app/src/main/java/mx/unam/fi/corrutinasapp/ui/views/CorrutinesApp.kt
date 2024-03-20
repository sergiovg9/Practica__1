package mx.unam.fi.corrutinasapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import mx.unam.fi.corrutinasapp.R
import mx.unam.fi.corrutinasapp.ui.theme.CorrutinasAppTheme
import mx.unam.fi.corrutinasapp.viewmodel.MainViewModel
import kotlin.math.exp

@Composable
fun CorountinesApp(viewModel: MainViewModel = MainViewModel(), modifier: Modifier = Modifier){

    var counTime2 by remember {
        mutableStateOf( 0.0)

    }
    var counTime4 by remember {
        mutableStateOf( 0.0)

    }
    var counTime6 by remember {
        mutableStateOf( 0.0)

    }
    var counTime8 by remember {
        mutableStateOf( 0.0)

    }
    var counTime10 by remember {
        mutableStateOf( 0.0)

    }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Button(onClick = {
            viewModel.fetchData()
        }) {
            Text(text = "Primer timer")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "${viewModel.counTime}")
        Text(text = "${viewModel.counTime3}")
        Text(text = "${viewModel.counTime5}")
        Text(text = "${viewModel.counTime7}")
        Text(text = "${viewModel.counTime9}")

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            for (i in 1..5) {
                Thread.sleep(1000)
                counTime2 = exp(i.toDouble())
            }
            for (i in 1..5) {
                Thread.sleep(1000)
                counTime4 = exp(i.toDouble())
            }
            for (i in 1..5) {
                Thread.sleep(1000)
                counTime6 = exp(i.toDouble())
            }
            for (i in 1..5) {
                Thread.sleep(1000)
                counTime8 = exp(i.toDouble())
            }
            for (i in 1..5) {
                Thread.sleep(1000)
                counTime10 = exp(i.toDouble())
            }
        }
        ) {
            Text(text = "Segundo timer")

        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = counTime2.toString())
        Text(text = counTime4.toString())
        Text(text = counTime6.toString())
        Text(text = counTime8.toString())
        Text(text = counTime10.toString())

        Spacer(modifier = modifier.height(30.dp))

        Button(onClick = {
            viewModel.cancelCountdowns()
        }) {
            Text(text = stringResource(R.string.pausa))
        }

    }
}

@Preview
@Composable
fun CoroutinesAppPreview(){
    CorrutinasAppTheme {
        CorountinesApp()
    }
}