package com.example.giftapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewAdapterViewHold> {

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


        TextView gift_view_text,noUnPurchasedGifts ;
        Button addToPurchased;
        ImageView imageDel;


        /**
         * Pass through the values that will used when building the recyclerview.
         * @param itemView
         */
        public ViewAdapterViewHold(@NonNull View itemView) {
            super(itemView);
            gift_view_text = itemView.findViewById(R.id.gift_view_text);
            imageDel = itemView.findViewById(R.id.imageDel);
            addToPurchased =  itemView.findViewById(R.id.giftIsPurchased);
            noUnPurchasedGifts = itemView.findViewById(R.id.noUnPurchased);

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
    public ViewAdapter.ViewAdapterViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewAdapter.ViewAdapterViewHold(LayoutInflater.from(context).inflate(R.layout.rows_of_items,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewAdapterViewHold holder, int position) {
        Gift gift = giftList.get(position);

        // Gift Info that will be displayed.
        String forWhom = "For: " + gift.getForWhom() + "\n";
        String fromWhom = "From: " + gift.getFromWhom() + "\n";
        String address = "Address: " + gift.getAddress() + "\n";
        String giftName = "Gift: " + gift.getGiftName() + "\n";
        String price = "Price: " + gift.getGiftPrice() + "\n";
        String notes = "Notes: " + gift.getGiftNotes() + "\n";
        String purchased = "Purchased: " + gift.getPurchased() + "\n";
        String text = forWhom + fromWhom + address + giftName + price + notes + purchased + "\n";
        String unPurchased = "You have no gifts yet";

        if(giftList.size() != 0){
            holder.gift_view_text.setText(text);
        }else{
            holder.noUnPurchasedGifts.setText(unPurchased);
        }

        holder.addToPurchased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gift purchasedGift = gift;
                int position = holder.getAdapterPosition();
                db.giftDao().updateGift(gift);
                giftList.remove(position);
                notifyItemRemoved(position);
                purchasedGift.setPurchased(true);
                clickedItem.UpdateGift(purchasedGift);



            }
        });;
        holder.imageDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = holder.getAdapterPosition();
                clickedItem.ClickedGift(gift);
                db.giftDao().deleteGift(gift);
                giftList.remove(position);
                notifyItemRemoved(position);

            }
        });




    }

    /**
     * Gives the size the recyclerview to improve performance.
     * @return
     */
    @Override
    public int getItemCount() {
        return giftList.size();
    }

    public ViewAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    /**
     * Clicked item interface.
     */
    public interface ClickedItem {
        public void ClickedGift(Gift gift);
        public void UpdateGift(Gift gift);
    }


    public void remove(int position, Gift gift) {
        //db.giftDao().deleteGift(gift);
        notifyDataSetChanged();
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, giftList.size());
    }

    public void clear() {
        int size = giftList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                giftList.remove(0);
            }
            notifyItemRangeRemoved(0,size);
            //notifyItemRangeRemoved(0, 0);
        }
    }

}
