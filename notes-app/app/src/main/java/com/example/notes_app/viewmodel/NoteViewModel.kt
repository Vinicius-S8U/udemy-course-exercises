package com.example.notes_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes_app.model.Note
import com.example.notes_app.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(
    app: Application,
    private val repository: NoteRepository
) : AndroidViewModel(app) {

    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) { repository.insertNote(note) }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) { repository.deleteNote(note) }

    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) { repository.updateNote(note) }

    fun getAllNotes() = repository.getAllNotes()

    fun searchNote(query: String) = repository.searchNote(query)
}