package com.pvsb.nybooks.data.repository

import com.pvsb.nybooks.data.api.NYTApi
import com.pvsb.nybooks.data.mapper.BookToResultMapper
import com.pvsb.nybooks.data.response.BookBodyResponse
import com.pvsb.nybooks.data.response.BookResultsResponse

class RepositoryImpl(val api: NYTApi): Repository {

    override suspend fun getBooks(): List<BookResultsResponse> {
        return BookToResultMapper.resultMap(api.getBooks())
    }
}