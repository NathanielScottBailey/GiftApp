/**
 * @auther Patrick
 * @version 1.0
 */
package com.example.giftapp;

public class Gift {
    public static final String LOG_TAG = "GiftAppLog: ";

    /**
     * Attributes for gift
     */
    private String forWhom, giftName, giftPrice, giftNotes;
    private boolean purchased;

    /**
     * Only notes can be empty
     * @param forWhom The name for whom the gift is for
     * @param giftName The name of the gift
     * @param giftPrice The price of the gift idea
     * @param giftNotes notes about the gift
     *        purchased whether or not the gift has been purchased
     */
    public Gift(String forWhom, String giftName, String giftPrice, String giftNotes, boolean purchased) {
        if(forWhom.isEmpty() || giftName.isEmpty() || giftPrice.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.forWhom = forWhom;
        this.giftName = giftName;
        this.giftPrice = giftPrice;
        this.purchased = false;
        if(giftNotes.isEmpty()){
            this.giftNotes = "";
        }else{
            this.giftNotes = giftNotes;
        }
    }

    public String getForWhom() {
        return forWhom;
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

    public void setPurchased(boolean purchased){
        this.purchased = purchased;
    }
}
