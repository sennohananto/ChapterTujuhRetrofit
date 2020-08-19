package com.binar.chaptertujuhretrofit.di

import com.binar.chaptertujuhretrofit.BuildConfig
import com.binar.chaptertujuhretrofit.add.AddPersonPresenter
import com.binar.chaptertujuhretrofit.main.MainPresenter
import com.binar.chaptertujuhretrofit.network.ApiService
import com.binar.chaptertujuhretrofit.update.UpdatePersonPresenter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = BuildConfig.SERVER_URL

val appModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    factory<ApiService> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }

    factory {
        (listener: MainPresenter.Listener) -> MainPresenter(listener, get())
    }

    factory {
        (listener: UpdatePersonPresenter.Listener) -> UpdatePersonPresenter(listener, get())
    }

    factory {
        (listener: AddPersonPresenter.Listener) -> AddPersonPresenter(listener, get())
    }
}