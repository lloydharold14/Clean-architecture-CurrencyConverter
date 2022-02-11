package com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto

data class Query(
    val apikey: String,
    val base_currency: String,
    val timestamp: Int
)