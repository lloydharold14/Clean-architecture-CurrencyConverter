package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

sealed class ConverterEvent {

    data class OnAmountChange( val amount: Double): ConverterEvent()
    object OnConversion: ConverterEvent()
    object OnReset: ConverterEvent()
    data class OnBaseCurrencyChange(val baseCurrency: String): ConverterEvent()
    data class OnToCurrencyChange(val toCurrency: String): ConverterEvent()

}