package com.example.myproject1.ui.rankuser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproject1.R

class RankingUser : Fragment() {

    companion object {
        fun newInstance() = RankingUser()
    }

    private lateinit var viewModel: RankingUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ranking_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RankingUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}