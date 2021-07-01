package com.pvsb.nybooks.presentation.books.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pvsb.nybooks.R
import com.pvsb.nybooks.data.response.BookDetailsResponse
import com.pvsb.nybooks.model.Book

class BooksAdapter(
   context: Context
): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private var mBookModelList: List<Book> = ArrayList()

    private lateinit var mBookListener: BooksListener

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(mBookModelList[position])
    }

    override fun getItemCount() = mBookModelList.size      //ou  :Int = books.size

    fun setBooks(book: List<Book>){
        this.mBookModelList = book
        updateList()
    }

    private fun updateList(){
        notifyDataSetChanged()
    }

    inner class BooksViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val author = itemView.findViewById<TextView>(R.id.textAuthor)
        fun bindView(book: Book){
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                mBookListener.onClick(adapterPosition)
            }
        }
    }

    fun attachListener(listener: BooksListener){
        mBookListener = listener
    }

    fun getData() = mBookModelList
}