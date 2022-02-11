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

class ConverterrepositoryImpl(
    private val api: ConverterApi
) : ConverterRepository {
    override fun getCurrenciesRates(base: String): Flow<Resource<CurrenciesDto>> = flow {
        emit(Resource.Loading())

        try {
            val currencyResponse = api.getLatestConversion(API_KEY, base)
            emit(Resource.Success(currencyResponse))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.message()
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    "Couldn't reach server, check your internet connection!",
                )
            )
        }


    }


}