package com.ouday.pokemon.details

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonDetailsServiceImpl @Inject constructor(private val api: PokemonDetailsApi) :
    PokemonDetailsService {

    override suspend fun fetchPokemonDetails(pokemonID: Int) = flow {
        emit(Result.success(api.fetchPokemonDetailsAsync(pokemonID)))
    }.catch {
        emit(Result.failure(it))
    }

}