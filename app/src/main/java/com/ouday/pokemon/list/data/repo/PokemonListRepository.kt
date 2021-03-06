package com.ouday.pokemon.list.data.repo

import com.ouday.pokemon.list.data.model.PokemonName
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun fetchAllPokemons(offset: Int, limit: Int) : Flow<Result<List<PokemonName>?>>
}