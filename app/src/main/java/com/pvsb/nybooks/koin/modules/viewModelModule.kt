package com.pvsb.nybooks.koin.modules

import com.pvsb.nybooks.presentation.books.BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {

    viewModel { BooksViewModel() }

}