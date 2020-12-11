package com.example.giftapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GiftDao {


    @Update
    void updateGift(Gift... gift);

    @Query("SELECT * FROM gift")
    List<Gift> getAllGifts ();

    @Query("SELECT * FROM gift WHERE purchased LIKE :decision ")
    List<Gift> getPurchasedGifts (boolean decision);

    @Delete
    void deleteGift(Gift gift);

    @Insert
    void insertAll(Gift... gifts);

    @Query("DELETE FROM gift")
    void nuke();
}
