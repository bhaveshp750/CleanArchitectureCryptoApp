package com.bhaveshp750.mycryptocurrencyapp.domain.use_case.get_coin

import com.bhaveshp750.mycryptocurrencyapp.common.Resource
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.toCoin
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.toCoinDetail
import com.bhaveshp750.mycryptocurrencyapp.domain.model.Coin
import com.bhaveshp750.mycryptocurrencyapp.domain.model.CoinDetail
import com.bhaveshp750.mycryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. CHeck your internet"))

        }
    }
}