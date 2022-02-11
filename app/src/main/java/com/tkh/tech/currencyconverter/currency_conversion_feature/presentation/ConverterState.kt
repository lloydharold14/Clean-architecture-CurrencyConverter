package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

class ConverterState(
    val baseCurrency: String = "USD",
    val toCurrency: String = "",
    val amount: Double = 0.0,
)