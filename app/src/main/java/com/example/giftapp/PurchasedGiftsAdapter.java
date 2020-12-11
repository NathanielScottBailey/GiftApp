
package com.example.giftapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PurchasedGiftsAdapter extends RecyclerView.Adapter<PurchasedGiftsAdapter.ViewAdapterViewHold> {
    private List<Gift> giftList;
    private Context context;
    private ClickedItem clickedItem;

    public AppDatabase db = AppDatabase.getInstance();



    /**
     * This will bring the passed Gift list inside the class.
     * @param giftList
     */
    public void setData(List<Gift> giftList) {
        this.giftList = giftList;
        notifyDataSetChanged();
    }

    /**
     * The view holder for the adapter
     */
    public class ViewAdapterViewHold extends RecyclerView.ViewHolder {


        TextView giftName, giftToWho, giftPrice, giftComment, giftAddress, giftFromWho, noPurchasedGifts;



        /**
         * Pass through the values that will used when building the recyclerview.
         * @param itemView
         */
        public ViewAdapterViewHold(@NonNull View itemView) {
            super(itemView);

            giftName = itemView.findViewById(R.id.giftNamePurchased);
            giftToWho = itemView.findViewById(R.id.giftToWhoPurchased);
            giftPrice = itemView.findViewById(R.id.giftPricePurchased);
            giftComment = itemView.findViewById(R.id.giftCommentPurchased);
            giftAddress = itemView.findViewById(R.id.giftAddressPurchased);
            giftFromWho = itemView.findViewById(R.id.fromWhomPurchased);
            noPurchasedGifts = itemView.findViewById(R.id.noPurchased);

        }
    }

    /**
     * When creating the view holder, find and attach to the rows_of_items activity.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public PurchasedGiftsAdapter.ViewAdapterViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new PurchasedGiftsAdapter.ViewAdapterViewHold(LayoutInflater.from(context).inflate(R.layout.rows_of_purchased_gifts,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAdapterViewHold holder, int position) {
        Gift gift = giftList.get(position);

        // Gift Info that will be displayed.
        String forWhom = "For " + gift.getForWhom() ;
        String giftName = "Gift: " + gift.getGiftName() ;
        String price = "$" + gift.getGiftPrice() ;
        String notes = "Comment: " + gift.getGiftNotes() ;
        String fromWhom = "From: " + gift.getFromWhom() ;
        String address = "Address: " + gift.getAddress();
        String notPurchased = "You have not purchased any gifts yet" ;


        if(giftList.size() != 0){
            holder.giftName.setText(giftName);
            holder.giftToWho.setText(forWhom);
            holder.giftPrice.setText(price);
            holder.giftComment.setText(notes);
            holder.giftFromWho.setText(fromWhom);
            holder.giftAddress.setText(address); }

        else{
            holder.noPurchasedGifts.setText(notPurchased);
        }
    }

    /**
     * Gives the size the recyclerview to improve performance.
     * @return
     */
    @Override
    public int getItemCount() {
        return giftList.size();
    }

    public PurchasedGiftsAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    /**
     * Clicked item interface.
     */
    public interface ClickedItem {
        public void ClickedGift(Gift gift);
    }

}
