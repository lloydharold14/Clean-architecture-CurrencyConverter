package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

data class ConverterState(

    val baseCurrency: String = "CAD",
    val toCurrency: String = "USD",
    val amount: Double = 0.0,
    val result: Double = 0.0,
    val isResultVisible: Boolean = false,
    val currencyCode: List<String> = emptyList()
)