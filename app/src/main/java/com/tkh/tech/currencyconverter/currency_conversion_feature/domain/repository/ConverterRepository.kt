package com.tkh.tech.currencyconverter.currency_conversion_feature.domain.repository

import com.tkh.tech.currencyconverter.core.util.Resource
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto.CurrenciesDto
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {

    suspend fun getCurrenciesRates(base: String): Result<CurrenciesDto>
}