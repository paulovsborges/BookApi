package com.pvsb.nybooks.presentation.books

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pvsb.nybooks.R
import com.pvsb.nybooks.model.constants.AppConstants
import com.pvsb.nybooks.databinding.ActivityMainBinding
import com.pvsb.nybooks.presentation.books.adapter.BooksAdapter
import com.pvsb.nybooks.presentation.books.adapter.BooksListener
import com.pvsb.nybooks.presentation.details.BookDetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

    private val viewModel: BooksViewModel by viewModel()

    private lateinit var mAdapter: BooksAdapter

    private lateinit var binding: ActivityMainBinding

    private lateinit var mListener: BooksListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
        setAdapter()
        observeEvents()
        configToolbar()
        initiateListener()
    }

    private fun initiateListener() {
        mAdapter.attachListener(mListener)
    }

    private fun setListeners() {
        mListener = object : BooksListener {
            override fun onClick(position: Int) {

                if(mAdapter.getData().isNotEmpty()){
                    val searchItem = mAdapter.getData()[position]
                    searchItem?.let{book ->
                        val intent = Intent(applicationContext, BookDetailsActivity::class.java)
                        intent.putExtra(AppConstants.INTENT_TITLE, book.title)
                        intent.putExtra(AppConstants.INTENT_DESCRIPTION, book.description)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun configToolbar() {
        binding.toolbarMain.title = getString(R.string.books_tittle)
        setSupportActionBar(binding.toolbarMain)
    }

    private fun setAdapter() {
        binding.recyclerBooks.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            mAdapter = BooksAdapter(this@MainActivity)
            adapter = mAdapter
        }
    }

    private fun observeEvents() {
        viewModel.booksLiveData.observe(this, Observer { bookList ->
            mAdapter.setBooks(bookList)
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let {
                binding.viewFlipperBooks.displayedChild = it.first
                it.second?.let {
                    binding.textViewError.text = getString(it)
                }
            }
        })
        viewModel.getBooks()
    }
}