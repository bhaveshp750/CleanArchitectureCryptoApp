package com.bhaveshp750.mycryptocurrencyapp.presentation.coin_detail

import com.bhaveshp750.mycryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
