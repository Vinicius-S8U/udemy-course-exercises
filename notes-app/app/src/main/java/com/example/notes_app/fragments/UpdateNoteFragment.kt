package com.example.notes_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notes_app.MainActivity
import com.example.notes_app.R
import com.example.notes_app.databinding.FragmentUpdateNoteBinding
import com.example.notes_app.model.Note
import com.example.notes_app.viewmodel.NoteViewModel

class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {

    private lateinit var binding: FragmentUpdateNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var currentNote: Note
    private val args: UpdateNoteFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainActivity).noteViewModel
        currentNote = args.note!!

        binding.updateNoteEtTitle.setText(currentNote.noteTitle)
        binding.updateNoteEtBody.setText(currentNote.noteBody)

        binding.updateNoteFabDone.setOnClickListener{
            val title = binding.updateNoteEtTitle.text.toString().trim()
            val body = binding.updateNoteEtTitle.text.toString().trim()

            if(title.isNotEmpty()){
                val note = Note(currentNote.id,title,body)
                noteViewModel.updateNote(note)
                view.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
            }else{
                Toast.makeText(context,"Enter a new note title",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun deleteNote(){
        activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("Delete Note")
                setMessage("Are you sure you want to delete this Note?")
                setPositiveButton("Delete"){_,_ ->
                    noteViewModel.deleteNote(currentNote)
                    view?.findNavController()?.navigate(R.id.action_updateNoteFragment_to_homeFragment)
                }
                setNegativeButton("Cancel",null)
            }.create().show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.update_note_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.update_note_menu_delete ->{
                deleteNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}