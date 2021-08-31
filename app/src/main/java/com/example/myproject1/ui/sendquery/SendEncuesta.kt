package com.example.myproject1.ui.sendquery

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myproject1.R

class SendEncuesta : Fragment() {

    companion object {
        fun newInstance() = SendEncuesta()
    }

    private lateinit var viewModel: SendEncuestaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.send_encuesta_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SendEncuestaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}