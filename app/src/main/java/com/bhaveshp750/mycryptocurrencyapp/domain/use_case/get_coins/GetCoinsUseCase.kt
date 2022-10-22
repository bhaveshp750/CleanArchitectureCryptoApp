package com.bhaveshp750.mycryptocurrencyapp.domain.use_case.get_coins

import com.bhaveshp750.mycryptocurrencyapp.common.Resource
import com.bhaveshp750.mycryptocurrencyapp.data.remote.dto.toCoin
import com.bhaveshp750.mycryptocurrencyapp.domain.model.Coin
import com.bhaveshp750.mycryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. CHeck your internet"))

        }
    }
}