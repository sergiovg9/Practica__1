package mx.unam.fi.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.exp

class MainViewModel : ViewModel(){

    var counTime by mutableStateOf(0.0)
        private set
    var counTime3 by mutableStateOf(0.0)
        private set
    var counTime5 by mutableStateOf(0.0)
        private set
    var counTime7 by mutableStateOf(0.0)
        private set
    var counTime9 by mutableStateOf(0.0)
        private set
    var oneCount by mutableStateOf(false)
        private set
    private var job: Job? = null

    fun fetchData() {
        job = viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                counTime = exp(i.toDouble())
            }
           for (u in 1..5) {
               delay(1000)
               counTime3 = exp(u.toDouble())
            }
            for (u in 1..5) {
                delay(1000)
                counTime5 = exp(u.toDouble())
            }
            for (u in 1..5) {
                delay(1000)
                counTime7 = exp(u.toDouble())
            }
            for (u in 1..5) {
                delay(1000)
                counTime9 = exp(u.toDouble())
            }
            oneCount = true
        }
        if (oneCount) {
            cancelCountdowns()
        }
    }

    fun cancelCountdowns() {
        job?.cancel()
    }
}