package com.denizgocer.notetakingfinal.dao

import androidx.room.*
import com.denizgocer.notetakingfinal.entities.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes ORDER BY pld DESC")
    suspend fun getAllNotes(): List<Notes>

    @Query("SELECT * FROM notes WHERE pld =:pld")
    suspend fun getSpecificNote(pld: Int): Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("DELETE FROM notes WHERE pld=:pld")
    suspend fun deleteSpecificNote(pld: Int)

    @Update
    suspend fun updateNote(note: Notes)

}
