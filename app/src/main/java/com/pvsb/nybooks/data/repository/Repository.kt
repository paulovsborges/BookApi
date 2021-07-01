package com.pvsb.nybooks.data.repository

import com.pvsb.nybooks.data.response.BookResultsResponse

interface Repository {

   suspend fun getBooks(): List<BookResultsResponse>
}