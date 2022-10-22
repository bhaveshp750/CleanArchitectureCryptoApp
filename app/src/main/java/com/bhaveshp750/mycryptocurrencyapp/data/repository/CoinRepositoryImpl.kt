package com.bhaveshp750.mycryptocurrencyapp.data.repository

import com.bhaveshp750.mycryptocurrencyapp.data.remote.CoinPaprikaApi
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.CoinDto
import com.bhaveshp750.mycryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}