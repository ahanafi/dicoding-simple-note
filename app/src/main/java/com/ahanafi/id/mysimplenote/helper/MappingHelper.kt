package com.ahanafi.id.mysimplenote.helper

import android.database.Cursor
import com.ahanafi.id.mysimplenote.database.DatabaseContract
import com.ahanafi.id.mysimplenote.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(notesCursor : Cursor) : ArrayList<Note> {
        val noteList = ArrayList<Note>()
        notesCursor.moveToFirst()
        while (notesCursor.moveToNext()) {
            val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
            val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
            val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
            val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
            noteList.add(Note(id, title, description, date))
        }

        return noteList
    }

}