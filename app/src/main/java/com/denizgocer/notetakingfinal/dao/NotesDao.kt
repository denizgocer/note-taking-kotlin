package com.denizgocer.notetakingfinal.dao
import androidx.room.*
import com.denizgocer.notetakingfinal.entities.Notes

@Dao
interface NotesDao {
    @get:Query("SELECT * FROM notes ORDER BY pld DESC")
    val allNotes: List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)

}
