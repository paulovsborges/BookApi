package com.pvsb.nybooks.data.mapper

import com.pvsb.nybooks.data.response.BookBodyResponse
import com.pvsb.nybooks.data.response.BookResultsResponse

internal object BookToResultMapper {

    fun resultMap(source: BookBodyResponse): List<BookResultsResponse> {
        val bookResultsList: MutableList<BookResultsResponse> = mutableListOf()
        source.let {bookBodyResponse ->
            for(bookResult  in bookBodyResponse.bookResults){
                bookResultsList.add(bookResult)
            }
        }
        return bookResultsList
    }
}