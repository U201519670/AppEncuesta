package com.example.myproject1.ui.ludocheck

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproject1.R

class LudopataCheck : Fragment() {

    companion object {
        fun newInstance() = LudopataCheck()
    }

    private lateinit var viewModel: LudopataCheckViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ludopata_check_fragment2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LudopataCheckViewModel::class.java)
        // TODO: Use the ViewModel
    }

}