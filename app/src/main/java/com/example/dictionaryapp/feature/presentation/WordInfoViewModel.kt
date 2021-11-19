package com.example.dictionaryapp.feature.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.feature.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val getWordInfo: GetWordInfo
) : ViewModel() {

    private val _searchQuery = MutableLiveData("")


    private val _state = MutableLiveData<WordInfoState>()
    val state: LiveData<WordInfoState> = _state


    private var searchJob: Job? = null


    init{
        _state.value=WordInfoState()
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            getWordInfo(query)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = WordInfoState(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false

                            )
                            Log.i("let me see3",_state.value.toString())

                        }
                        is Resource.Error -> {
                            _state.value = WordInfoState(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            Log.i("let me see2",_state.value.toString())


                        }
                        is Resource.Loading -> {
                            _state.value = WordInfoState(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                            Log.i("let me see1",_state.value.toString())
                        }
                    }
                }.launchIn(this)
        }
    }




}