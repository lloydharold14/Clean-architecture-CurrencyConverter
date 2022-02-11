package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

sealed class ConverterEvent {

    data class OnConvertClick(val baseCurrency: String, val amount: Double) : ConverterEvent()
}