package com.pvsb.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pvsb.nybooks.R
import com.pvsb.nybooks.data.repository.Repository
import com.pvsb.nybooks.data.response.BookBodyResponse
import com.pvsb.nybooks.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class BooksViewModel(

    private val repository: Repository

) : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.getBooks()
            }.onSuccess {listBook ->
                val books: MutableList<Book> = mutableListOf()
                listBook.let {listBookResponse ->
                    for (result in listBookResponse) {
                        val book = result.bookDetailResponses[0].getBookModel()
                        books.add(book)
                    }
                }
                booksLiveData.postValue(books)
                viewFlipperLiveData.postValue(Pair(VIEW_FLIPPER_BOOKS, null))
            }.onFailure {
                viewFlipperLiveData.postValue(
                    Pair(
                        VIEW_FLIPPER_ERROR,
                        R.string.books_error_400_generic
                    )
                )
            }
        }
    }

    companion object {
        private const val VIEW_FLIPPER_BOOKS = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}
