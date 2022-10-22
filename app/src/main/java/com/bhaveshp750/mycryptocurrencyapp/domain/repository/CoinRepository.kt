package com.bhaveshp750.mycryptocurrencyapp.domain.repository

import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}