package com.tkh.tech.currencyconverter.currency_conversion_feature.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun ConverterScreen(
    viewModel: ConverterViewModel = hiltViewModel()
) {

    val scrollState = rememberScrollState()
    val state = viewModel.state
    val softKeyboardFocusManager = LocalFocusManager.current
    var expanded by remember {
        mutableStateOf(listOf(false, false, false))


    }
    var amount by remember {
        mutableStateOf("")
    }
    val animatedResult by animateFloatAsState(
        targetValue = state.result.toFloat(),
        animationSpec = tween(500)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "CURRENCY CONVERTER",
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))

        DropDownBox(
            dropDownList = viewModel.currencyCode,
            textValue = state.baseCurrency,
            labelText = "Convert from",
            scrollState = scrollState,
            isExpanded = expanded[0],
            expandStatus = {
                if (state.currencyCode.isNotEmpty()) {
                    expanded = listOf(it, false)
                }
            },
            valueChange = {
                viewModel.onEvent(ConverterEvent.OnBaseCurrencyChange(it))
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        IconButton(
            onClick = {
                state.isResultVisible

            },
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "MoreVert",
                tint = MaterialTheme.colors.primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        DropDownBox(
            dropDownList = viewModel.currencyCode,
            textValue = state.toCurrency,
            labelText = "Convert to",
            scrollState = scrollState,
            isExpanded = expanded[1],
            expandStatus = {
                if (state.currencyCode.isNotEmpty()) {
                    expanded = listOf(false, it)
                }
            },
            valueChange = {
                viewModel.onEvent(ConverterEvent.OnToCurrencyChange(it))
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.amount.toString(),
            onValueChange = {
                viewModel.onEvent(ConverterEvent.OnAmountChange(it.toDouble()))
            }
        )
    }
}