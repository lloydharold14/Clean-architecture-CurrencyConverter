package com.tkh.tech.currencyconverter.currency_conversion_feature.data.repository

import com.tkh.tech.currencyconverter.core.util.Constants.Companion.API_KEY
import com.tkh.tech.currencyconverter.core.util.Resource
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.ConverterApi
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto.CurrenciesDto
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.repository.ConverterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.lang.Exception

class ConverterRepositoryImpl(
    private val api: ConverterApi
) : ConverterRepository {
    override suspend fun getCurrenciesRates(base: String): Result<CurrenciesDto> {

        return try {
            val currency = api.getLatestConversion(API_KEY, base)
            Result.success(currency)

        } catch (e: Exception) {

            e.printStackTrace()
            Result.failure(e)
        }


    }


}