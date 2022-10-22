package com.bhaveshp750.mycryptocurrencyapp.presentation.coin_list

import com.bhaveshp750.mycryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
