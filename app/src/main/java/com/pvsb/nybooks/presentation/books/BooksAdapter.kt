package com.pvsb.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pvsb.nybooks.R
import com.pvsb.nybooks.data.model.Book

class BooksAdapter(

    val books: List<Book>,
    val onItemClickListener: ((book:Book) -> Unit)

): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {

     //   val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
     //   return BooksViewHolder(binding,)

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

        holder.bindView(books[position])

    }

    override fun getItemCount() = books.count()       //ou  :Int = books.size

    inner class BooksViewHolder( itemView: View, private val onItemClickListener: ((book:Book) -> Unit)): RecyclerView.ViewHolder(itemView){
        
        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val author = itemView.findViewById<TextView>(R.id.textAuthor)

        fun bindView(book: Book){
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener(book)

            }

        }
    }
}