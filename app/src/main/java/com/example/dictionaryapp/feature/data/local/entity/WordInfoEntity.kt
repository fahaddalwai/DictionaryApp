package com.example.dictionaryapp.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature.data.remote.dto.MeaningDto
import com.example.dictionaryapp.feature.domain.model.Meaning
import com.example.dictionaryapp.feature.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    @PrimaryKey
    val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            origin = origin,
            phonetic = phonetic,
            word = word


        )
    }
}
