package com.example.dictionaryapp.feature.data.remote.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
)