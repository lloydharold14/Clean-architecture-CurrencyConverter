package com.tkh.tech.currencyconverter.currency_conversion_feature.domain.repository

import com.tkh.tech.currencyconverter.core.util.Resource
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto.CurrenciesDto
import kotlinx.coroutines.flow.Flow

interface CurenciesRepository {

     fun getCurrenciesRates(base: String): Flow<Resource<List<CurrenciesDto>>>
}