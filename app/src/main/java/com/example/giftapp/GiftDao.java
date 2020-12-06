package com.example.giftapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GiftDao {

    @Query("SELECT * FROM gift")
    List<Gift> getAllGifts ();

    @Delete
    void deleteGift(Gift gift);
//
//    @Query("DELETE FROM gift WHERE  ")
//    public void delete(Gif gif)

    @Insert
    void insertAll(Gift... gifts);

    @Query("DELETE FROM gift")
    public void nuke();
}
