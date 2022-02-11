package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.repository.ConverterRepository
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.use_case.RatesConversion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    repository: ConverterRepository,
    ratesConversion: RatesConversion
)   : ViewModel() {

    var state by mutableStateOf(ConverterState())
        private set

    fun onEvent(event: ConverterEvent){
        when(event) {
            is ConverterEvent.OnConvertClick -> {
                viewModelScope.launch {

                }
            }
        }

    }
}