package com.pvsb.nybooks.presentation.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pvsb.nybooks.R
import com.pvsb.nybooks.model.constants.AppConstants
import com.pvsb.nybooks.databinding.ActivityBookDetailsBinding

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configToolbar()
        setExtras()
    }

    private fun setExtras() {
        if (intent.hasExtra(AppConstants.INTENT_TITLE) && intent.getStringExtra(AppConstants.INTENT_TITLE) != null)
            binding.bookDetailsTitle.text = intent.getStringExtra(AppConstants.INTENT_TITLE)!!
        if (intent.hasExtra(AppConstants.INTENT_DESCRIPTION) && intent.getStringExtra(AppConstants.INTENT_DESCRIPTION) != null)
            binding.bookDetailsDescription.text = intent.getStringExtra(AppConstants.INTENT_DESCRIPTION)!!
    }

    private fun configToolbar() {
        binding.toolbarMain.title = getString(R.string.books_title_details)
        setSupportActionBar(binding.toolbarMain)
    }
}