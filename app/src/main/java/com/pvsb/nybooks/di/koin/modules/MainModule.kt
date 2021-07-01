package com.pvsb.nybooks.di.koin.modules

import com.pvsb.nybooks.data.api.NYTApi
import com.pvsb.nybooks.data.repository.Repository
import com.pvsb.nybooks.data.repository.RepositoryImpl
import com.pvsb.nybooks.data.retrofit.createApi
import com.pvsb.nybooks.data.retrofit.provideOkHttpClient
import com.pvsb.nybooks.data.retrofit.provideRetrofit
import com.pvsb.nybooks.presentation.books.BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { BooksViewModel(repository = get()) }
}

val repositoryModule = module {

    single <Repository>{ RepositoryImpl(api = get()) }
}

val networkModule = module {

    single { provideOkHttpClient() }
    single { provideRetrofit(okHttpClient = get()) }
    single { createApi<NYTApi>(retrofit = get()) }
}