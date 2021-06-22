package com.pvsb.nybooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pvsb.nybooks.R
import com.pvsb.nybooks.databinding.ActivityMainBinding
import com.pvsb.nybooks.presentation.details.BookDetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: BooksViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = getString(R.string.books_tittle)
        setSupportActionBar(binding.toolbarMain)


        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(binding.recyclerBooks) {
                    layoutManager =
                        LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books){book ->

                        val intent = BookDetailsActivity.getStartIntent(this@MainActivity, book.title, book.description)
                        this@MainActivity.startActivity(intent)
                    }
                }
            }
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