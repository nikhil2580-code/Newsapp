package com.nikhilkhairnar.thenewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.nikhilkhairnar.thenewsapp.R
import com.nikhilkhairnar.thenewsapp.databinding.FragmentArticleBinding
import com.nikhilkhairnar.thenewsapp.ui.NewsActivity
import com.nikhilkhairnar.thenewsapp.ui.NewsViewModel


class ArticleFragment : Fragment(R.layout.fragment_article) {

   lateinit var newsViewModel: NewsViewModel
   val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }

        }
        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view,"Added to favourites",Snackbar.LENGTH_SHORT).show()
        }
    }




}