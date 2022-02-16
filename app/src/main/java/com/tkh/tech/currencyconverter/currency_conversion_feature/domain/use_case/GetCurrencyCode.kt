package com.tkh.tech.currencyconverter.currency_conversion_feature.domain.use_case

import com.tkh.tech.currencyconverter.core.util.Constants.Companion.CURRENCY_CODE


class GetCurrencyCode {

    operator fun invoke(): List<String> {

        return CURRENCY_CODE

    }
}