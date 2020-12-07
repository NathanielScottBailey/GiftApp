/**
 * @auther Patrick
 * @version 1.0
 */
package com.example.giftapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Gift {
    public static final String LOG_TAG = "GiftAppLog: ";

    /**
     * Attributes for gift
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "forWhom")
    private String forWhom;

    @ColumnInfo(name = "fromWhom")
    private String fromWhom;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "giftName")
    private String giftName;

    @ColumnInfo(name = "giftPrice")
    private String giftPrice;

    @ColumnInfo(name = "giftNotes")
    private String giftNotes;

    @ColumnInfo(name = "purchased")
    private boolean purchased;

    /**
     * Only notes can be empty
     * @param forWhom The name for whom the gift is for
     * @param giftName The name of the gift
     * @param giftPrice The price of the gift idea
     * @param giftNotes notes about the gift
     *        purchased whether or not the gift has been purchased
     */
    public Gift(String forWhom, String fromWhom, String address, String giftName, String giftPrice, String giftNotes, boolean purchased) {
        if(forWhom.isEmpty() || giftName.isEmpty() || giftPrice.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.forWhom = forWhom;
        this.fromWhom = fromWhom;
        this.address = address;
        this.giftName = giftName;
        this.giftPrice = giftPrice;
        this.purchased = purchased;
        if(giftNotes.isEmpty()){
            this.giftNotes = "";
        }else{
            this.giftNotes = giftNotes;
        }
    }

    public int getId() {
        return id;
    }


    public String getForWhom() {
        return forWhom;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public String getAddress() {
        return address;
    }

    public String getGiftName() {
        return giftName;
    }

    public String getGiftPrice() {
        return giftPrice;
    }

    public String getGiftNotes() {
        return giftNotes;
    }

    public boolean getPurchased(){ return purchased; }

    public void setGiftNotes(String giftNotes) {
        this.giftNotes = giftNotes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public void setGiftPrice(String giftPrice) {
        this.giftPrice = giftPrice;
    }

    public void setPurchased(boolean purchased){
        this.purchased = purchased;
    }

}
