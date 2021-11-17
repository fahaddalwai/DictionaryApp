package com.example.dictionaryapp.feature.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionaryapp.feature.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val getWordInfo: GetWordInfo
) : ViewModel() {

    private val _searchQuery= MutableLiveData<String>("")
    val searchQuery: LiveData<String> = _searchQuery

    private val _state=MutableLiveData<WordInfoState>()
    val state:LiveData<WordInfoState> = _state

    private val _eventflow=MutableSharedFlow<UIEvent>()
    val eventFlow: SharedFlow<UIEvent> = _eventflow


    sealed class UIEvent{
        data class ShowSnackbar(val messgae:String):UIEvent()
    }


}