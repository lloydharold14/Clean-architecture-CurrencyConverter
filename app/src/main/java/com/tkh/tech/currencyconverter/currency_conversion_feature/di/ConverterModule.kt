package com.tkh.tech.currencyconverter.currency_conversion_feature.di

import com.tkh.tech.currencyconverter.core.util.Constants.Companion.BASE_URL
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.ConverterApi
import com.tkh.tech.currencyconverter.currency_conversion_feature.data.repository.ConverterrepositoryImpl
import com.tkh.tech.currencyconverter.currency_conversion_feature.domain.repository.ConverterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object ConverterModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyConverterApi(okHttpClient: OkHttpClient): ConverterApi {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesConverterRepository(api: ConverterApi): ConverterRepository {
        return ConverterrepositoryImpl(
            api = api
        )
    }
}


