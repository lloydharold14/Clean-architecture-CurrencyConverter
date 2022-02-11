package com.tkh.tech.currencyconverter.currency_conversion_feature.domain.use_case

import com.tkh.tech.currencyconverter.currency_conversion_feature.data.remote.dto.RatesDto
import kotlin.math.round

class RatesConversion {

    operator fun invoke(
        amount: Double,
        toCurrency: String,
        rate: RatesDto
    ): Double {

        val conversionRate = getCurrencyRate(toCurrency, rate)
        return round(amount * conversionRate * 100) / 100

    }

    private fun getCurrencyRate(toCurrency: String, rate: RatesDto) = when (toCurrency) {


        "JPY" -> rate.JPY
        "CNY" -> rate.CNY
        "CHF" -> rate.CHF
        "CAD" -> rate.CAD
        "MXN" -> rate.MXN
        "INR" -> rate.INR
        "BRL" -> rate.BRL
        "RUB" -> rate.RUB
        "KRW" -> rate.KRW
        "IDR" -> rate.IDR
        "TRY" -> rate.TRY
        "SAR" -> rate.SAR
        "SEK" -> rate.SEK
        "NGN" -> rate.NGN
        "PLN" -> rate.PLN
        "ARS" -> rate.ARS
        "NOK" -> rate.NOK
        "TWD" -> rate.TWD
        "IRR" -> rate.IRR
        "AED" -> rate.AED
        "COP" -> rate.COP
        "THB" -> rate.THB
        "ZAR" -> rate.ZAR
        "DKK" -> rate.DKK
        "MYR" -> rate.MYR
        "SGD" -> rate.SGD
        "ILS" -> rate.ILS
        "HKD" -> rate.HKD
        "EGP" -> rate.EGP
        "PHP" -> rate.PHP
        "CLP" -> rate.CLP
        "PKR" -> rate.PKR
        "IQD" -> rate.IQD
        "DZD" -> rate.DZD
        "KZT" -> rate.KZT
        "QAR" -> rate.QAR
        "CZK" -> rate.CZK
        "PEN" -> rate.PEN
        "RON" -> rate.RON
        "VND" -> rate.VND
        "BDT" -> rate.BDT
        "HUF" -> rate.HUF
        "UAH" -> rate.UAH
        "AOA" -> rate.AOA
        "MAD" -> rate.MAD
        "OMR" -> rate.OMR
        "CUC" -> rate.CUC
        "BYR" -> rate.BYR
        "AZN" -> rate.AZN
        "LKR" -> rate.LKR
        "SDG" -> rate.SDG
        "SYP" -> rate.SYP
        "MMK" -> rate.MMK
        "DOP" -> rate.DOP
        "UZS" -> rate.UZS
        "KES" -> rate.KES
        "GTQ" -> rate.GTQ
        "URY" -> rate.URY
        "HRV" -> rate.HRV
        "MOP" -> rate.MOP
        "ETB" -> rate.ETB
        "CRC" -> rate.CRC
        "TZS" -> rate.TZS
        "TMT" -> rate.TMT
        "TND" -> rate.TND
        "PAB" -> rate.PAB
        "LBP" -> rate.LBP
        "RSD" -> rate.RSD
        "LYD" -> rate.LYD
        "GHS" -> rate.GHS
        "YER" -> rate.YER
        "BOB" -> rate.BOB
        "BHD" -> rate.BHD
        "CDF" -> rate.CDF
        "PYG" -> rate.PYG
        "UGX" -> rate.UGX
        "SVC" -> rate.SVC
        "TTD" -> rate.TTD
        "AFN" -> rate.AFN
        "NPR" -> rate.NPR
        "HNL" -> rate.HNL
        "BIH" -> rate.BIH
        "BND" -> rate.BND
        "ISK" -> rate.ISK
        "KHR" -> rate.KHR
        "GEL" -> rate.GEL
        "MZN" -> rate.MZN
        "BWP" -> rate.BWP
        "PGK" -> rate.PGK
        "JMD" -> rate.JMD
        "XAF" -> rate.XAF
        "NAD" -> rate.NAD
        "ALL" -> rate.ALL
        "SSP" -> rate.SSP
        "MUR" -> rate.MUR
        "MNT" -> rate.MNT
        "NIO" -> rate.NIO
        "LAK" -> rate.LAK
        "MKD" -> rate.MKD
        "AMD" -> rate.AMD
        "MGA" -> rate.MGA
        "XPF" -> rate.XPF
        "TJS" -> rate.TJS
        "HTG" -> rate.MGA
        "BSD" -> rate.BSD
        "MDL" -> rate.MDL
        "RWF" -> rate.RWF
        "KGS" -> rate.KGS
        "GNF" -> rate.GNF
        "SRD" -> rate.SRD
        "SLL" -> rate.SLL
        "XOF" -> rate.XOF
        "MWK" -> rate.MWK
        "FJD" -> rate.FJD
        "ERN" -> rate.ERN
        "SZL" -> rate.SZL
        "GYD" -> rate.GYD
        "BIF" -> rate.BIF
        "KYD" -> rate.KYD
        "MVR" -> rate.MVR
        "LSL" -> rate.LSL
        "LRD" -> rate.LRD
        "CVE" -> rate.CVE
        "DJF" -> rate.DJF
        "SCR" -> rate.SCR
        "SOS" -> rate.SOS
        "GMD" -> rate.GMD
        "KMF" -> rate.KMF
        "STD" -> rate.STD
        "BTC" -> rate.BTC
        "XRP" -> rate.XRP
        "AUD" -> rate.AUD
        "BGN" -> rate.BGN
        "JOD" -> rate.JOD
        "GBP" -> rate.GBP
        "ETH" -> rate.ETH
        "EUR" -> rate.EUR
        "LTC" -> rate.LTC
        "NZD" -> rate.NZD
        else -> rate.USD
    }

}