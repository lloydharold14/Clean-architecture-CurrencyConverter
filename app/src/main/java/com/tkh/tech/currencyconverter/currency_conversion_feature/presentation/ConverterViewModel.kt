package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tkh.tech.currencyconverter.core.UIEvent
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.use_case.CalculateRate
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.use_case.GetCurrencyCode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val getCurrencyCode: GetCurrencyCode,
    private val ratesConversion: CalculateRate
) : ViewModel() {

    var state by mutableStateOf(ConverterState())
    private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    val currencyCode = getCurrencyCode()

    fun onEvent(event: ConverterEvent) {
        when (event) {
            is ConverterEvent.OnBaseCurrencyChange -> {
                state = state.copy(baseCurrency = event.baseCurrency)
            }
            is ConverterEvent.OnToCurrencyChange -> {
                state = state.copy(toCurrency = event.toCurrency)
            }
            is ConverterEvent.OnAmountChange -> {
                state = state.copy(amount = event.amount)
            }
        }

    }



}