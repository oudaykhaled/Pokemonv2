package com.ouday.pokemon.core

import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val client = OkHttpClient()
val idlingResource = OkHttp3IdlingResource.create("okhttp", client)

private const val URL_POKEMON = "https://pokeapi.co/api/v2/"

@Module
@InstallIn(FragmentComponent::class)
class AppModule {

    @Provides
    fun retrofit() = Retrofit.Builder()
        .baseUrl(URL_POKEMON)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}