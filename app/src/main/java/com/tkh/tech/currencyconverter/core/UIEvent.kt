package com.tkh.tech.currencyconverter.core

sealed class UIEvent {
    object Success: UIEvent()
    data class SnackBar(val message: String): UIEvent()
}