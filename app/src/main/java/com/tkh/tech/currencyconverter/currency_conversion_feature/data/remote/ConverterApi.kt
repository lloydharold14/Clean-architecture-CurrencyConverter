package com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote

import com.tkh.tech.currencyconverter.core.util.Constants.Companion.API_KEY
import com.tkh.tech.currencyconverter.core.util.Resource
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto.CurrenciesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConverterApi {

    @GET("latest")
    suspend fun getLatestConversion(
        @Query("apiKey")
        apiKey: String = API_KEY,
        @Query("base_currency")
        base: String,
    ): CurrenciesDto
}