package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.example.dictionaryapp.feature.presentation.WordInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.dictionaryapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: WordInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)



        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        binding.editText.addTextChangedListener { editable->
            editable?.let{
                if(it.toString().isNotEmpty() || it.isNotBlank()){
                    viewModel.onSearch(it.toString())
                    Log.i("itscheck", it.toString())
                }
            }
        }



    }
}